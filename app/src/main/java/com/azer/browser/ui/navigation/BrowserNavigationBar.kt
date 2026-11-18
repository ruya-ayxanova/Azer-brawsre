package com.azer.browser.ui.navigation

import android.content.Context
import android.graphics.Color
import android.widget.Button
import android.widget.LinearLayout

object BrowserNavigationBar {

    fun create(
        context: Context,
        onBack: () -> Unit,
        onForward: () -> Unit,
        onReload: () -> Unit,
        onStop: () -> Unit,
        onHome: () -> Unit
    ): LinearLayout {

        val bar = LinearLayout(context)
        bar.orientation = LinearLayout.HORIZONTAL
        bar.setBackgroundColor(Color.rgb(27, 39, 49))

        fun button(label: String, action: () -> Unit) {
            val btn = Button(context)
            btn.text = label
            btn.textSize = 12f
            btn.setPadding(0, 0, 0, 0)
            btn.setOnClickListener { action() }

            bar.addView(
                btn,
                LinearLayout.LayoutParams(0, 48, 1f)
            )
        }

        button("‹", onBack)
        button("›", onForward)
        button("↻", onReload)
        button("×", onStop)
        button("⌂", onHome)

        return bar
    }
}
