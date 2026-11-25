package com.azer.browser

import android.webkit.WebView

class AzerWebViewController41(
    private val webView: WebView
) {

    private val loadManager =
        AzerWebLoadManager41()

    private val navigation =
        AzerWebNavigationControl41()

    fun open(url: String): AzerNavigationResult41 {
        return loadManager.load(webView, url)
    }

    fun back(): Boolean {
        return navigation.goBack(webView)
    }

    fun forward(): Boolean {
        return navigation.goForward(webView)
    }

    fun reload() {
        loadManager.reload(webView)
    }

    fun stop() {
        loadManager.stop(webView)
    }

    fun getPageInfo(): AzerWebPageInfo41 {
        return AzerWebPageInfoFactory41.create(webView)
    }
}
