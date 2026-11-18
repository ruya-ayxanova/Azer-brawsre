package com.azer.browser.ui.tabs

import android.content.Context
import android.widget.Button

object BrowserTabOpenButton {

    fun create(
        context: Context,
        onOpen: () -> Unit
    ): Button {
        return Button(context).apply {
            text = "+ Yeni Sekme"
            setOnClickListener {
                onOpen()
            }
        }
    }
}
