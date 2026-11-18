package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebView
import android.widget.LinearLayout
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

class MainActivity : Activity() {

    private lateinit var root: LinearLayout
    private lateinit var content: LinearLayout

    private val tabRegistry = BrowserTabRegistry()

    private var isBrowsing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(BrowserTheme.background)

        content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL

        createNewTab(false)

        showHome()
        setContentView(root)
    }

    private fun createNewTab(showOverview: Boolean = true) {
        val webView = BrowserTabWebViewFactory.create(this)

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
                    url = url,
                    userAgent = userAgent,
                    contentDisposition = contentDisposition,
                    mimeType = mimeType,
                    cookies = cookies
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

        if (showOverview) {
            showTabs()
        }
    }

    private fun setupLayout() {
        root.removeAllViews()

        val toolbar = BrowserToolbar.create(
            this,
            onSearch = { openAddress(it) },
            onHome = { showHome() }
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

    private fun showContent(view: android.view.View) {
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
                context = this,
                entries = tabRegistry.entries(),
                onSelect = { index ->
                    switchTab(index)
                },
                onClose = { index ->
                    closeTab(index)
                },
                onNewTab = {
                    createNewTab()
                }
            )
        )
    }

    private fun switchTab(index: Int) {
        val selected = tabRegistry.activate(index)

        if (selected != null) {
            isBrowsing = selected.url.isNotBlank()
                && selected.url != "azer://home"

            showContent(selected)
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

        val active = tabRegistry.getActive()

        if (active != null) {
            isBrowsing = active.url.isNotBlank()
                && active.url != "azer://home"
            showContent(active)
        } else {
            showTabs()
        }
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
