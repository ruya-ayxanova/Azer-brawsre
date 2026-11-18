package com.azer.browser.ui.bookmarks

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.widget.TextView

object BookmarkHeaderView {

    fun create(context: Context, count: Int): TextView {
        return TextView(context).apply {
            text = "⭐ Yer İmleri\n${BookmarkCountFormatter.format(count)}"
            textSize = 20f
            setTextColor(Color.BLACK)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(24, 24, 24, 20)
        }
    }
}
