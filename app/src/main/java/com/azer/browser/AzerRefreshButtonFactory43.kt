package com.azer.browser

import android.content.Context
import android.widget.Button

object AzerRefreshButtonFactory43 {
    fun create(context: Context): Button {
        return Button(context).apply {
            text = "⟳"
            contentDescription = "Yenile"
            textSize = 20f
        }
    }
}
