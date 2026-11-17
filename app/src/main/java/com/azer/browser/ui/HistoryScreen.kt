package com.azer.browser.ui

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView

object HistoryScreen {

    fun create(context: Context): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 20, 20, 20)
        layout.setBackgroundColor(BrowserTheme.background)

        val title = TextView(context)
        title.text = "Gezinme Geçmişi"
        title.textSize = 24f
        title.setTextColor(BrowserTheme.text)

        val preferences = context.getSharedPreferences(
            "azer_history",
            Context.MODE_PRIVATE
        )

        val history = preferences.getStringSet(
            "items",
            emptySet()
        ) ?: emptySet()

        layout.addView(title)

        if (history.isEmpty()) {
            val empty = TextView(context)
            empty.text = "Henüz gezinme geçmişi yok."
            empty.setTextColor(BrowserTheme.secondaryText)
            layout.addView(empty)
        } else {
            history.toList().asReversed().forEach { url ->
                val item = TextView(context)
                item.text = url
                item.textSize = 14f
                item.setTextColor(BrowserTheme.secondaryText)
                item.setPadding(0, 10, 0, 10)
                layout.addView(item)
            }
        }

        return layout
    }
}
