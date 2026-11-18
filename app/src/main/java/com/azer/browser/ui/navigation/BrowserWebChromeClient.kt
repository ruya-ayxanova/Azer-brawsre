package com.azer.browser.ui.navigation

import android.webkit.WebChromeClient
import android.webkit.WebView

class BrowserWebChromeClient(
    private val listener: BrowserPageListener
) : WebChromeClient() {

    override fun onProgressChanged(
        view: WebView,
        newProgress: Int
    ) {
        listener.onProgressChanged(newProgress)
    }

    override fun onReceivedTitle(
        view: WebView,
        title: String?
    ) {
        listener.onPageFinished(
            view.url.orEmpty(),
            title.orEmpty()
        )
    }
}
