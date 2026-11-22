package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object BrowserTabBadgeFactory {

    fun create(
        context: Context,
        count: Int
    ): TextView {

        val badge = TextView(context)

        badge.text = count.toString()
        badge.textSize = 14f
        badge.setTextColor(Color.WHITE)
        badge.gravity = Gravity.CENTER

        badge.setPadding(12, 6, 12, 6)

        badge.setBackgroundColor(
            Color.rgb(45, 100, 75)
        )

        return badge
    }
}
