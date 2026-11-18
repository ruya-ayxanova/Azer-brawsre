package com.azer.browser.ui.bookmarks

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

object BookmarkListItem {

    fun create(
        context: Context,
        bookmark: Bookmark,
        onOpen: (Bookmark) -> Unit,
        onDelete: (Bookmark) -> Unit
    ): LinearLayout {

        val row = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(16, 12, 12, 12)
        }

        val content = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
        }

        val title = TextView(context).apply {
            text = bookmark.title
            textSize = 16f
            setTextColor(Color.BLACK)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 2
        }

        val url = TextView(context).apply {
            text = bookmark.url
            textSize = 12f
            setTextColor(Color.GRAY)
            maxLines = 1
        }

        content.addView(title)
        content.addView(url)

        val deleteButton = TextView(context).apply {
            text = "🗑"
            textSize = 22f
            gravity = Gravity.CENTER
            setPadding(16, 8, 8, 8)
            setOnClickListener {
                onDelete(bookmark)
            }
        }

        row.addView(
            content,
            LinearLayout.LayoutParams(0, -2, 1f)
        )

        row.addView(
            deleteButton,
            LinearLayout.LayoutParams(-2, -2)
        )

        row.setOnClickListener {
            onOpen(bookmark)
        }

        return row
    }
}
