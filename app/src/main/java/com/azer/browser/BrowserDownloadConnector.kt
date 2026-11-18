package com.azer.browser

import android.content.Context
import android.webkit.WebView

object BrowserDownloadConnector {

    fun connect(
        webView: WebView,
        context: Context
    ) {
        webView.setDownloadListener(
            BrowserDownloadListener(context)
        )
    }

    fun openDownloads(context: Context) {
        DownloadIntegration.initialize(context)

        DownloadLauncher.open(context)
    }
}
