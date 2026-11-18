package com.azer.browser.ui.bookmarks

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object BookmarkEmptyView {

    fun create(context: Context): TextView {
        return TextView(context).apply {
            text = """
                ⭐

                Henüz yer imi yok

                Sevdiğin web sitelerini buraya ekleyebilirsin.
            """.trimIndent()

            textSize = 18f
            setTextColor(Color.GRAY)
            gravity = Gravity.CENTER
            setPadding(32, 48, 32, 48)
        }
    }
}
