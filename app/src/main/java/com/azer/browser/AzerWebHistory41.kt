package com.azer.browser

import android.webkit.WebView

class AzerWebHistory41 {

    fun getCurrentUrl(webView: WebView): String {
        return webView.url ?: ""
    }

    fun getTitle(webView: WebView): String {
        return webView.title ?: ""
    }

    fun clear(webView: WebView) {
        webView.clearHistory()
    }

    fun getBackForwardList(
        webView: WebView
    ): android.webkit.WebBackForwardList {
        return webView.copyBackForwardList()
    }
}
