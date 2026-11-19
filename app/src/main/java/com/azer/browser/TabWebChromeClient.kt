package com.azer.browser

import android.webkit.WebChromeClient
import android.webkit.WebView

class TabWebChromeClient(
    private val tabId: String,
    private val callbacks: TabWebViewCallbacks
) : WebChromeClient() {

    override fun onReceivedTitle(
        view: WebView?,
        title: String?
    ) {
        super.onReceivedTitle(view, title)
        callbacks.onPageTitleChanged(
            tabId,
            title ?: "Yeni sekme"
        )
    }

    override fun onProgressChanged(
        view: WebView?,
        newProgress: Int
    ) {
        super.onProgressChanged(view, newProgress)
        callbacks.onPageProgress(tabId, newProgress)
    }
}
