package com.azer.browser.ui.downloads

import android.content.Context
import android.widget.Button

object DownloadCancelAction {

    fun create(
        context: Context,
        onCancel: () -> Unit
    ): Button {
        return Button(context).apply {
            text = "İptal"
            setOnClickListener {
                onCancel()
            }
        }
    }
}
