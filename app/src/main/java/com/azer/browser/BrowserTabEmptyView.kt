package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object BrowserTabEmptyView {

    fun create(
        context: Context
    ): TextView {

        val view = TextView(context)

        view.text = "Açık sekme bulunmuyor"
        view.textSize = 18f
        view.setTextColor(Color.GRAY)
        view.gravity = Gravity.CENTER

        view.setPadding(32, 48, 32, 48)

        return view
    }
}
