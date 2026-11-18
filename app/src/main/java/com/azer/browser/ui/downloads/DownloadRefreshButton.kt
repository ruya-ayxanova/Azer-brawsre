package com.azer.browser.ui.downloads

import android.content.Context
import android.widget.Button

object DownloadRefreshButton {

    fun create(
        context: Context,
        onRefresh: () -> Unit
    ): Button {
        return Button(context).apply {
            text = "Listeyi Yenile"
            setOnClickListener {
                onRefresh()
            }
        }
    }
}
