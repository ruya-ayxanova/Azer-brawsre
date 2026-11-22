package com.azer.browser

import android.view.View
import android.webkit.WebView

object BrowserWebTabVisibility39 {

    fun show(webView: WebView) {
        webView.visibility = View.VISIBLE
    }

    fun hide(webView: WebView) {
        webView.visibility = View.GONE
    }

    fun isVisible(webView: WebView): Boolean {
        return webView.visibility == View.VISIBLE
    }
}
