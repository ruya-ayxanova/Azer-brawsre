package com.azer.browser

import android.content.Context
import android.widget.Button

object AzerTabButtonFactory43 {
    fun create(context: Context): Button {
        return Button(context).apply {
            text = "1"
            contentDescription = "Sekmeler"
            textSize = 14f
        }
    }
}
