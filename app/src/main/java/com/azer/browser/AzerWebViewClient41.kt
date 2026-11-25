package com.azer.browser

import android.webkit.WebView
import android.webkit.WebViewClient

class AzerWebViewClient41(
    private val onPageStartedCallback: (String) -> Unit = {},
    private val onPageFinishedCallback: (String) -> Unit = {},
    private val onErrorCallback: (String) -> Unit = {}
) : WebViewClient() {

    override fun onPageStarted(
        view: WebView,
        url: String,
        favicon: android.graphics.Bitmap?
    ) {
        super.onPageStarted(view, url, favicon)
        onPageStartedCallback(url)
    }

    override fun onPageFinished(
        view: WebView,
        url: String
    ) {
        super.onPageFinished(view, url)
        onPageFinishedCallback(url)
    }

    override fun onReceivedError(
        view: WebView,
        request: android.webkit.WebResourceRequest,
        error: android.webkit.WebResourceError
    ) {
        super.onReceivedError(view, request, error)

        if (request.isForMainFrame) {
            onErrorCallback(error.description.toString())
        }
    }
}
