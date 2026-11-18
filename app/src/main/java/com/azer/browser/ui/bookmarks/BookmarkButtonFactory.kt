package com.azer.browser.ui.bookmarks

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

object BookmarkButtonFactory {

    fun create(
        context: Context,
        isSaved: Boolean,
        onClick: () -> Unit
    ): TextView {

        return TextView(context).apply {
            text = if (isSaved) "★" else "☆"
            textSize = 26f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setPadding(12, 8, 12, 8)
            contentDescription = "Yer imlerine ekle"
            setOnClickListener {
                onClick()
            }
        }
    }
}
