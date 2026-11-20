
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.TextView

class BrowserToolbarButton(
    context: Context,
    label: String,
    action: () -> Unit
) : TextView(context) {

    init {
        text = label
        textSize = 20f
        typeface = Typeface.DEFAULT_BOLD
        gravity = Gravity.CENTER
        setTextColor(Color.rgb(27, 94, 65))
        setPadding(10, 8, 10, 8)

        background = GradientDrawable().apply {
            setColor(Color.rgb(240, 245, 241))
            cornerRadius = 12f
        }

        setOnClickListener {
            action()
        }
    }

    fun setEnabledState(enabled: Boolean) {
        isEnabled = enabled
        alpha = if (enabled) 1f else 0.35f
    }
}
