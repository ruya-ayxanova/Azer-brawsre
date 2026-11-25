package com.azer.browser

import android.webkit.WebView

class AzerWebNavigationControl41 {

    fun canGoBack(webView: WebView): Boolean {
        return webView.canGoBack()
    }

    fun canGoForward(webView: WebView): Boolean {
        return webView.canGoForward()
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
