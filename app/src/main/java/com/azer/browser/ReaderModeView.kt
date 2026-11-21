package com.azer.browser

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient

class ReaderModeView(context: Context) : WebView(context) {

    init {
        settings.javaScriptEnabled = false
        settings.domStorageEnabled = false
        settings.allowFileAccess = false
        settings.allowContentAccess = false

        webViewClient = WebViewClient()
    }

    fun display(html: String) {
        loadDataWithBaseURL(
            null,
            html,
            "text/html",
            "UTF-8",
            null
        )
    }

    fun clearReader() {
        loadData("", "text/html", "UTF-8")
    }
}
