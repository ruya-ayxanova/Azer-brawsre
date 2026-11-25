package com.azer.browser

import android.webkit.WebChromeClient
import android.webkit.WebView

class AzerWebChromeClient41(
    private val onProgressChangedCallback: (Int) -> Unit = {},
    private val onTitleChangedCallback: (String) -> Unit = {}
) : WebChromeClient() {

    override fun onProgressChanged(
        view: WebView,
        newProgress: Int
    ) {
        super.onProgressChanged(view, newProgress)
        onProgressChangedCallback(newProgress)
    }

    override fun onReceivedTitle(
        view: WebView,
        title: String?
    ) {
        super.onReceivedTitle(view, title)
        onTitleChangedCallback(title ?: "")
    }
}
