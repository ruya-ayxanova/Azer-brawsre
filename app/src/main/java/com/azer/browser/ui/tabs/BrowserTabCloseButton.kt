package com.azer.browser.ui.tabs

import android.content.Context
import android.widget.Button

object BrowserTabCloseButton {

    fun create(
        context: Context,
        onClose: () -> Unit
    ): Button {
        return Button(context).apply {
            text = "✕"
            setOnClickListener {
                onClose()
            }
        }
    }
}
