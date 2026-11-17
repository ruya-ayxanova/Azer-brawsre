package com.azer.browser

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.azer.browser.ui.BookmarkScreen
import com.azer.browser.ui.BrowserBottomBar
import com.azer.browser.ui.BrowserTheme
import com.azer.browser.ui.BrowserToolbar
import com.azer.browser.ui.DownloadScreen
import com.azer.browser.ui.HistoryScreen
import com.azer.browser.ui.HomeScreen
import com.azer.browser.ui.SettingsScreen
import com.azer.browser.ui.TabScreen

class MainActivity : Activity() {

    private lateinit var root: LinearLayout
    private lateinit var content: LinearLayout
    private lateinit var webView: WebView

    private var tabCount = 1
    private var isBrowsing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(BrowserTheme.background)

        content = LinearLayout(this)
        content.orientation = LinearLayout.VERTICAL

        webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()

        showHome()
        setContentView(root)
    }

    private fun setupLayout() {
        root.removeAllViews()

        val toolbar = BrowserToolbar.create(
            this,
            onSearch = { address -> openAddress(address) },
            onHome = { showHome() }
        )

        val bottomBar = BrowserBottomBar.create(
            this
        ) { selected ->
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
        showContent(
            HomeScreen.create(this) { address ->
                openAddress(address)
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
            TabScreen.create(
                this,
                tabCount,
                onNewTab = {
                    tabCount++
                    showHome()
                    Toast.makeText(
                        this,
                        "Yeni sekme oluşturuldu.",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onPrivateTab = {
                    Toast.makeText(
                        this,
                        "Gizli sekme sonraki aşamada geliştirilecek.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        )
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
                "Adres gir.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val url = if (
            value.startsWith("http://") ||
            value.startsWith("https://")
        ) {
            value
        } else if (value.contains(".") && !value.contains(" ")) {
            "https://$value"
        } else {
            "https://www.google.com/search?q=" +
                android.net.Uri.encode(value)
        }

        isBrowsing = true

        webView.loadUrl(url)
        showContent(webView)

        val preferences = getSharedPreferences(
            "azer_history",
            MODE_PRIVATE
        )

        val oldItems = preferences.getStringSet(
            "items",
            emptySet()
        )?.toMutableSet() ?: mutableSetOf()

        oldItems.add(url)

        preferences.edit()
            .putStringSet("items", oldItems)
            .apply()
    }

    override fun onBackPressed() {
        if (isBrowsing && webView.canGoBack()) {
            webView.goBack()
        } else {
            showHome()
        }
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}
