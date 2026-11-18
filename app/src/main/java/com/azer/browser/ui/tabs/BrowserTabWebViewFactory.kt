package com.azer.browser.ui.tabs

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient

object BrowserTabWebViewFactory {

    fun create(context: Context): WebView {
        return WebView(context).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadsImagesAutomatically = true
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            webViewClient = WebViewClient()
        }
    }
}
