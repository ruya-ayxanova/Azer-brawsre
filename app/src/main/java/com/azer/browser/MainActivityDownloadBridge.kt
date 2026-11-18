package com.azer.browser

import android.app.Activity
import android.view.View
import android.webkit.WebView

object MainActivityDownloadBridge {

    fun initialize(
        activity: Activity,
        webView: WebView
    ) {
        DownloadIntegration.initialize(activity)

        BrowserWebViewManager.configure(
            webView,
            activity
        )
    }

    fun showDownloadMenu(
        activity: Activity,
        menuButton: View
    ) {
        DownloadMenuController.show(
            activity,
            menuButton
        )
    }

    fun openDownloadPage(activity: Activity) {
        DownloadLauncher.open(activity)
    }

    fun refreshDownloads(activity: Activity) {
        DownloadIntegration.refresh(activity)
    }
}
