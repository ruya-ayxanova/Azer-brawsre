package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.azer.browser.download.system.DownloadRequestInfo
import com.azer.browser.download.system.SystemDownloadManager
import com.azer.browser.ui.BookmarkScreen
import com.azer.browser.ui.BrowserBottomBar
import com.azer.browser.ui.BrowserTheme
import com.azer.browser.ui.BrowserToolbar
import com.azer.browser.ui.DownloadScreen
import com.azer.browser.ui.HistoryScreen
import com.azer.browser.ui.HomeScreen
import com.azer.browser.ui.SettingsScreen
import com.azer.browser.ui.tabs.BrowserTabOverviewScreen
import com.azer.browser.ui.tabs.BrowserTabRegistry
import com.azer.browser.ui.tabs.BrowserTabWebViewFactory
import com.azer.browser.ui.navigation.BrowserNavigationBar
import com.azer.browser.ui.navigation.BrowserProgressView
import com.azer.browser.ui.navigation.BrowserLoadingController
import com.azer.browser.ui.navigation.BrowserTitleFormatter
import com.azer.browser.ui.navigation.BrowserErrorView
import com.azer.browser.ui.navigation.BrowserWebChromeClient
import com.azer.browser.ui.navigation.BrowserPageListener

class MainActivity : Activity(), BrowserPageListener {

    private lateinit var root: LinearLayout
    private lateinit var content: LinearLayout
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingController: BrowserLoadingController

    private val tabRegistry = BrowserTabRegistry()

    private var isBrowsing = false
    private var lastErrorUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(BrowserTheme.background)

        content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL

        progressBar = BrowserProgressView.create(this)
        loadingController = BrowserLoadingController(progressBar)

        createNewTab(false)

        showHome()
        setContentView(root)
    }

    private fun createNewTab(showOverview: Boolean = true) {
        val webView = BrowserTabWebViewFactory.create(this)

        webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(
                view: WebView,
                url: String,
                favicon: android.graphics.Bitmap?
            ) {
                lastErrorUrl = null
                onPageStarted(url)
            }

            override fun onPageFinished(
                view: WebView,
                url: String
            ) {
                onPageFinished(
                    url,
                    view.title.orEmpty()
                )
            }

            override fun onReceivedError(
                view: WebView,
                request: android.webkit.WebResourceRequest,
                error: android.webkit.WebResourceError
            ) {
                if (request.isForMainFrame) {
                    onPageError(
                        request.url.toString(),
                        error.description.toString()
                    )
                }
            }
        }

        webView.webChromeClient = BrowserWebChromeClient(this)

        webView.setDownloadListener {
            url,
            userAgent,
            contentDisposition,
            mimeType,
            _ ->

            try {
                val cookies = CookieManager
                    .getInstance()
                    .getCookie(url)

                val info = DownloadRequestInfo(
                    url,
                    userAgent,
                    contentDisposition,
                    mimeType,
                    cookies
                )

                val result = SystemDownloadManager(this).start(info)

                Toast.makeText(
                    this,
                    "${result.fileName} indiriliyor",
                    Toast.LENGTH_LONG
                ).show()

            } catch (e: Exception) {
                Toast.makeText(
                    this,
                    "İndirme başlatılamadı",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        tabRegistry.add(webView)

        if (showOverview) showTabs()
    }

    private fun setupLayout() {
        root.removeAllViews()

        val toolbar = BrowserToolbar.create(
            this,
            onSearch = { openAddress(it) },
            onHome = { showHome() }
        )

        val activeWebView = tabRegistry.getActive()

        val navigationBar = BrowserNavigationBar.create(
            this,
            onBack = {
                activeWebView?.let {
                    if (!it.canGoBack()) {
                        Toast.makeText(
                            this,
                            "Geri sayfa yok",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        it.goBack()
                    }
                }
            },
            onForward = {
                activeWebView?.let {
                    if (it.canGoForward()) it.goForward()
                }
            },
            onReload = {
                activeWebView?.reload()
            },
            onStop = {
                activeWebView?.stopLoading()
                loadingController.finish()
            },
            onHome = {
                showHome()
            }
        )

        val bottomBar = BrowserBottomBar.create(this) { selected ->
            when (selected) {
                "Ana Sayfa" -> showHome()
                "İndirilenler" -> showDownloads()
                "Sekmeler" -> showTabs()
                "Yer İmleri" -> showBookmarks()
                "Geçmiş" -> showHistory()
                "Ayarlar" -> showSettings()
            }
        }

        root.addView(
            toolbar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                58
            )
        )

        root.addView(
            navigationBar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                48
            )
        )

        root.addView(
            progressBar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                4
            )
        )

        root.addView(
            content,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        root.addView(
            bottomBar,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                58
            )
        )
    }

    private fun showContent(view: View) {
        content.removeAllViews()

        content.addView(
            view,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )

        setupLayout()
    }

    private fun showHome() {
        isBrowsing = false
        loadingController.finish()

        showContent(
            HomeScreen.create(this) {
                openAddress(it)
            }
        )
    }

    private fun showDownloads() {
        isBrowsing = false
        showContent(DownloadScreen.create(this))
    }

    private fun showTabs() {
        isBrowsing = false

        showContent(
            BrowserTabOverviewScreen.create(
                this,
                tabRegistry.entries(),
                onSelect = { switchTab(it) },
                onClose = { closeTab(it) },
                onNewTab = { createNewTab() }
            )
        )
    }

    private fun switchTab(index: Int) {
        val webView = tabRegistry.activate(index)

        if (webView != null) {
            isBrowsing = !webView.url.isNullOrBlank()
                && webView.url != "azer://home"

            showContent(webView)
        } else {
            showHome()
        }
    }

    private fun closeTab(index: Int) {
        val removed = tabRegistry.close(index)

        removed?.let {
            it.stopLoading()
            it.destroy()
        }

        if (tabRegistry.count == 0) {
            createNewTab(false)
            showHome()
            return
        }

        tabRegistry.getActive()?.let {
            isBrowsing = !it.url.isNullOrBlank()
                && it.url != "azer://home"
            showContent(it)
        } ?: showTabs()
    }

    private fun showBookmarks() {
        isBrowsing = false
        showContent(BookmarkScreen.create(this))
    }

    private fun showHistory() {
        isBrowsing = false
        showContent(HistoryScreen.create(this))
    }

    private fun showSettings() {
        isBrowsing = false
        showContent(SettingsScreen.create(this))
    }

    private fun openAddress(input: String) {
        val value = input.trim()

        if (value.isEmpty()) {
            Toast.makeText(
                this,
                "Adres gir",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val url = when {
            value.startsWith("https://", true) ||
            value.startsWith("http://", true) -> value

            value.contains(".") && !value.contains(" ") ->
                "https://$value"

            else ->
                "https://www.google.com/search?q=" +
                    android.net.Uri.encode(value)
        }

        var webView = tabRegistry.getActive()

        if (webView == null) {
            createNewTab(false)
            webView = tabRegistry.getActive()
        }

        webView ?: return

        val index = tabRegistry.activeIndex()
        tabRegistry.setUrl(index, url)

        isBrowsing = true
        lastErrorUrl = null

        loadingController.start()

        webView.loadUrl(url)
        showContent(webView)

        val preferences = getSharedPreferences(
            "azer_history",
            MODE_PRIVATE
        )

        val items = preferences
            .getStringSet("items", emptySet())
            ?.toMutableSet()
            ?: mutableSetOf()

        items.add(url)

        preferences.edit()
            .putStringSet("items", items)
            .apply()
    }

    override fun onPageStarted(url: String) {
        runOnUiThread {
            isBrowsing = true
            lastErrorUrl = null
            loadingController.start()

            val index = tabRegistry.activeIndex()
            tabRegistry.setUrl(index, url)
        }
    }

    override fun onPageFinished(url: String, title: String) {
        runOnUiThread {
            val index = tabRegistry.activeIndex()

            tabRegistry.setUrl(index, url)
            tabRegistry.setTitle(
                index,
                BrowserTitleFormatter.format(title, url)
            )

            loadingController.finish()
        }
    }

    override fun onProgressChanged(progress: Int) {
        runOnUiThread {
            loadingController.update(progress)
        }
    }

    override fun onPageError(url: String, message: String) {
        runOnUiThread {
            lastErrorUrl = url
            loadingController.finish()

            Toast.makeText(
                this,
                "Sayfa yüklenirken hata oluştu",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @Deprecated("Deprecated Android callback")
    override fun onBackPressed() {
        val webView = tabRegistry.getActive()

        if (isBrowsing && webView != null && webView.canGoBack()) {
            webView.goBack()
        } else {
            showHome()
        }
    }

    override fun onDestroy() {
        tabRegistry.clear()
        super.onDestroy()
    }
}
