
package com.azer.browser

import android.content.Context
import android.webkit.WebView

object TabWebViewFactory {

    fun create(
        context: Context,
        tabId: String,
        callbacks: TabWebViewCallbacks
    ): WebView {
        val webView = WebView(context)

        TabWebViewConfig.configure(webView)

        webView.webViewClient = TabWebViewClient(
            tabId,
            callbacks
        )

        webView.webChromeClient = TabWebChromeClient(
            tabId,
            callbacks
        )

        return webView
    }
}
