package com.azer.browser.ui.tabs

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

object BrowserTabCardView {

    fun create(
        context: Context,
        entry: BrowserTabEntry,
        onSelect: () -> Unit,
        onClose: () -> Unit
    ): LinearLayout {

        val card = LinearLayout(context)
        card.orientation = LinearLayout.VERTICAL
        card.setPadding(16, 12, 16, 12)

        card.setBackgroundColor(
            if (entry.isActive)
                Color.rgb(0, 90, 80)
            else
                Color.rgb(35, 45, 55)
        )

        val title = TextView(context)
        title.text = if (entry.isActive) {
            "● ${entry.title}"
        } else {
            entry.title
        }

        title.textSize = 17f
        title.setTextColor(Color.WHITE)

        val url = TextView(context)
        url.text = entry.url
        url.textSize = 12f
        url.setTextColor(Color.LTGRAY)
        url.maxLines = 2

        val buttons = LinearLayout(context)
        buttons.orientation = LinearLayout.HORIZONTAL
        buttons.gravity = Gravity.CENTER_VERTICAL

        val select = android.widget.Button(context)
        select.text = "Aç"
        select.setOnClickListener {
            onSelect()
        }

        val close = BrowserTabCloseButton.create(context) {
            onClose()
        }

        buttons.addView(select)
        buttons.addView(close)

        card.addView(title)
        card.addView(url)
        card.addView(buttons)

        card.setOnClickListener {
            onSelect()
        }

        return card
    }
}
