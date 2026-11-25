package com.azer.browser

import android.webkit.WebView

object AzerWebPageInfoFactory41 {

    fun create(webView: WebView): AzerWebPageInfo41 {

        return AzerWebPageInfo41(
            url = webView.url ?: "",
            title = webView.title ?: "",
            progress = webView.progress,
            isLoading = webView.progress < 100,
            canGoBack = webView.canGoBack(),
            canGoForward = webView.canGoForward()
        )
    }
}
