package com.azer.browser.ui

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

object BookmarkScreen {

    fun create(context: Context): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 20, 20, 20)
        layout.setBackgroundColor(BrowserTheme.background)

        val title = TextView(context)
        title.text = "Yer İmleri"
        title.textSize = 24f
        title.setTextColor(BrowserTheme.text)

        val info = TextView(context)
        info.text = "Kaydettiğin internet siteleri burada görünecek."
        info.textSize = 15f
        info.setTextColor(BrowserTheme.secondaryText)

        val preferences = context.getSharedPreferences(
            "azer_bookmarks",
            Context.MODE_PRIVATE
        )

        val saved = preferences.getStringSet("items", emptySet())
            ?: emptySet()

        layout.addView(title)
        layout.addView(info)

        if (saved.isEmpty()) {
            val empty = TextView(context)
            empty.text = "Henüz yer imi eklenmedi."
            empty.setTextColor(BrowserTheme.secondaryText)
            layout.addView(empty)
        } else {
            saved.forEach { url ->
                val item = TextView(context)
                item.text = url
                item.textSize = 15f
                item.setTextColor(BrowserTheme.primary)
                item.setPadding(0, 12, 0, 12)
                layout.addView(
                    item,
                    ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            }
        }

        return layout
    }
}
