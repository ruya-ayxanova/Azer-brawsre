package com.azer.browser.ui.tabs

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object BrowserTabCounterView {

    fun create(context: Context, count: Int): TextView {
        return TextView(context).apply {
            text = "Sekmeler: $count"
            textSize = 14f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setPadding(12, 8, 12, 8)
            setBackgroundColor(Color.rgb(0, 120, 110))
        }
    }
}
