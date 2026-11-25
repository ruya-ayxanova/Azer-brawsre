package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout

object AzerToolbarFactory43 {

    fun create(context: Context): LinearLayout {
        return LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(
                AzerToolbarColors43.background
            )
            setPadding(4, 2, 4, 2)

            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dp(context, 56)
            )
        }
    }

    private fun dp(
        context: Context,
        value: Int
    ): Int {
        return (value * context.resources
            .displayMetrics.density).toInt()
    }
}
