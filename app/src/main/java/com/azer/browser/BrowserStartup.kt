package com.azer.browser

import android.app.Activity
import android.webkit.WebView

object BrowserStartup {

    fun initialize(
        activity: Activity,
        webView: WebView
    ) {
        DownloadIntegration.initialize(activity)

        BrowserWebViewManager.configure(
            webView,
            activity
        )

        if (webView.url.isNullOrBlank()) {
            BrowserWebViewManager.openHome(webView)
        }
    }

    fun refreshDownloads(activity: Activity) {
        DownloadProgressTracker.update(activity)
    }
}
