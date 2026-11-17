package com.azer.browser.ui

import android.content.Context
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

object BrowserBottomBar {

    fun create(
        context: Context,
        onSelect: (String) -> Unit
    ): LinearLayout {

        val bar = LinearLayout(context)
        bar.orientation = LinearLayout.HORIZONTAL
        bar.gravity = Gravity.CENTER
        bar.setBackgroundColor(BrowserTheme.surface)

        val items = listOf(
            "Ana Sayfa",
            "İndirilenler",
            "Sekmeler",
            "Yer İmleri",
            "Geçmiş",
            "Ayarlar"
        )

        items.forEach { item ->
            val button = Button(context)
            button.text = item
            button.textSize = 9f
            button.setPadding(2, 4, 2, 4)
            button.setOnClickListener { onSelect(item) }

            bar.addView(
                button,
                LinearLayout.LayoutParams(0, 58, 1f)
            )
        }

        return bar
    }
}
