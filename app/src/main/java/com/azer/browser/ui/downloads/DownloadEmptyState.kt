package com.azer.browser.ui.downloads

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object DownloadEmptyState {

    fun create(context: Context): TextView {
        return TextView(context).apply {
            text = "Henüz dosya indirilmedi."
            textSize = 17f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(24, 30, 24, 30)
        }
    }
}
