package com.azer.browser

import android.webkit.WebView

object BrowserWebTabNavigation39 {

    fun load(
        webView: WebView,
        url: String
    ): Boolean {
        if (url.isBlank()) return false

        webView.loadUrl(url)
        return true
    }

    fun reload(webView: WebView) {
        webView.reload()
    }

    fun goBack(webView: WebView): Boolean {
        if (!webView.canGoBack()) return false

        webView.goBack()
        return true
    }

    fun goForward(webView: WebView): Boolean {
        if (!webView.canGoForward()) return false

        webView.goForward()
        return true
    }
}
