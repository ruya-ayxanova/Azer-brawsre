package com.azer.browser.ui.bookmarks

import android.content.Context
import android.view.View
import android.widget.TextView

object BookmarkMenuAction {

    fun create(
        context: Context,
        onClick: () -> Unit
    ): View {

        return TextView(context).apply {
            text = "⭐ Yer İmleri"
            textSize = 17f
            setPadding(24, 18, 24, 18)
            setOnClickListener {
                onClick()
            }
        }
    }
}
