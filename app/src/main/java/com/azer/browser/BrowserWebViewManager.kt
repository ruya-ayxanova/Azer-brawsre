package com.azer.browser

import android.content.Context
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

object BrowserWebViewManager {

    fun configure(
        webView: WebView,
        context: Context
    ) {
        webView.settings.apply {
            javaScriptEnabled = BrowserConfig.ENABLE_JAVASCRIPT
            domStorageEnabled = BrowserConfig.ENABLE_DOM_STORAGE
            cacheMode = WebSettings.LOAD_DEFAULT
            loadsImagesAutomatically = true
            allowFileAccess = false
            javaScriptCanOpenWindowsAutomatically = false
            mixedContentMode = WebSettings.MIXED_CONTENT_NEVER_ALLOW
        }

        webView.webViewClient = WebViewClient()

        DownloadIntegration.connectWebView(
            webView,
            context
        )
    }

    fun openHome(webView: WebView) {
        webView.loadUrl(BrowserConfig.HOME_URL)
    }

    fun loadUrl(webView: WebView, url: String) {
        if (url.startsWith("https://") ||
            url.startsWith("http://")) {
            webView.loadUrl(url)
        }
    }
}
