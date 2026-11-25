package com.azer.browser

import android.content.Context
import android.widget.Button

object AzerForwardButtonFactory43 {
    fun create(context: Context): Button {
        return Button(context).apply {
            text = "›"
            contentDescription = "İleri"
            textSize = 24f
        }
    }
}
