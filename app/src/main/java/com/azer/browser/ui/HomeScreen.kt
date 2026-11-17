package com.azer.browser.ui

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

object HomeScreen {

    fun create(
        context: Context,
        onSearch: (String) -> Unit
    ): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 24, 24, 24)
        layout.setBackgroundColor(BrowserTheme.background)

        val title = TextView(context)
        title.text = "AZER BROWSER"
        title.textSize = 30f
        title.setTextColor(BrowserTheme.primary)
        title.gravity = Gravity.CENTER

        val subtitle = TextView(context)
        subtitle.text = "Hızlı ve kolay internet tarayıcısı"
        subtitle.textSize = 15f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER

        val sites = listOf(
            "Google" to "https://www.google.com",
            "YouTube" to "https://m.youtube.com",
            "Wikipedia" to "https://www.wikipedia.org"
        )

        layout.addView(title)
        layout.addView(subtitle)

        sites.forEach { (name, url) ->
            val button = Button(context)
            button.text = name
            button.setOnClickListener { onSearch(url) }

            layout.addView(
                button,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    55
                )
            )
        }

        return layout
    }
}
