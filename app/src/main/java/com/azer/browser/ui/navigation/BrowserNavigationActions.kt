package com.azer.browser.ui.navigation

import android.webkit.WebView

object BrowserNavigationActions {

    fun back(webView: WebView): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return false
    }

    fun forward(webView: WebView): Boolean {
        if (webView.canGoForward()) {
            webView.goForward()
            return true
        }
        return false
    }

    fun reload(webView: WebView) {
        webView.reload()
    }

    fun stop(webView: WebView) {
        webView.stopLoading()
    }

    fun home(webView: WebView) {
        webView.loadUrl("https://www.google.com")
    }
}
