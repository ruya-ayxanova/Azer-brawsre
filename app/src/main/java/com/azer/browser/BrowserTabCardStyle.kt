package com.azer.browser

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

object BrowserTabCardStyle {

    fun background(
        active: Boolean
    ): GradientDrawable {

        val drawable = GradientDrawable()

        drawable.cornerRadius = 24f

        drawable.setColor(
            if (active) Color.rgb(220, 235, 225)
            else Color.WHITE
        )

        drawable.setStroke(
            2,
            if (active) Color.rgb(50, 130, 90)
            else Color.LTGRAY
        )

        return drawable
    }
}
