package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object BrowserTabNewCard {

    fun create(
        context: Context
    ): TextView {

        val view = TextView(context)

        view.text = "+\nYeni sekme"
        view.textSize = 20f
        view.gravity = Gravity.CENTER
        view.setTextColor(Color.rgb(40, 110, 80))

        view.setPadding(30, 40, 30, 40)

        view.tag = "new_browser_tab"

        return view
    }
}
