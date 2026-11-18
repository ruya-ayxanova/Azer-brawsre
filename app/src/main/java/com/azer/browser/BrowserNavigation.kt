package com.azer.browser

import android.app.Activity
import android.content.Intent
import android.webkit.WebView

object BrowserNavigation {

    fun openDownloads(activity: Activity) {
        activity.startActivity(
            Intent(
                activity,
                DownloadListActivity::class.java
            )
        )
    }

    fun openSettings(activity: Activity) {
        activity.startActivity(
            Intent(
                activity,
                DownloadSettingsActivity::class.java
            )
        )
    }

    fun goBack(webView: WebView): Boolean {
        return if (webView.canGoBack()) {
            webView.goBack()
            true
        } else {
            false
        }
    }
}
