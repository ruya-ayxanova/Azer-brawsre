package com.azer.browser

import android.content.Context
import android.webkit.WebView

class AzerWebViewEngine52(context: Context) {

    val webView: WebView = WebView(context)

    init {
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = false
    }

    fun getWebView(): WebView = webView

    fun destroy() {
        webView.stopLoading()
        webView.loadUrl("about:blank")
        webView.clearHistory()
        webView.removeAllViews()
        webView.destroy()
    }
}
