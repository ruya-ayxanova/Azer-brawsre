package com.azer.browser

import android.content.Context
import android.widget.Button

object AzerHomeButtonFactory43 {
    fun create(context: Context): Button {
        return Button(context).apply {
            text = "⌂"
            contentDescription = "Ana sayfa"
            textSize = 20f
        }
    }
}
