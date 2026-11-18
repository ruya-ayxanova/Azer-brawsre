package com.azer.browser

import android.content.Context
import android.content.Intent

object DownloadLauncher {

    fun open(context: Context) {
        val intent = Intent(
            context,
            DownloadListActivity::class.java
        )

        context.startActivity(intent)
    }

    fun openSettings(context: Context) {
        val intent = Intent(
            context,
            DownloadSettingsActivity::class.java
        )

        context.startActivity(intent)
    }
}
