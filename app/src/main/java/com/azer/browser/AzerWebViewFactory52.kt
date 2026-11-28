package com.azer.browser

import android.content.Context
import android.webkit.WebView

object AzerWebViewFactory52 {

    fun create(context: Context): WebView {
        val webView = WebView(context)
        AzerWebViewSettings52.apply(webView)
        return webView
    }
}
