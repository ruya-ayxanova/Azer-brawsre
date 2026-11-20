
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BookmarkItemView(
    context: Context,
    private val bookmark: Bookmark,
    private val onOpen: (Bookmark) -> Unit,
    private val onMore: (Bookmark) -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(12, 12, 8, 12)

        background = GradientDrawable().apply {
            setColor(Color.WHITE)
            cornerRadius = 12f
            setStroke(1, Color.LTGRAY)
        }

        val details = LinearLayout(context).apply {
            orientation = VERTICAL
            setOnClickListener {
                onOpen(bookmark)
            }
        }

        val title = TextView(context).apply {
            text = bookmark.title
            textSize = 15f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.DKGRAY)
            maxLines = 1
        }

        val url = TextView(context).apply {
            text = bookmark.url
            textSize = 12f
            setTextColor(Color.GRAY)
            maxLines = 1
            setPadding(0, 4, 0, 0)
        }

        details.addView(title)
        details.addView(url)

        val more = TextView(context).apply {
            text = "⋮"
            textSize = 24f
            gravity = Gravity.CENTER
            setTextColor(Color.DKGRAY)
            setPadding(14, 4, 14, 4)

            setOnClickListener {
                onMore(bookmark)
            }
        }

        addView(
            details,
            LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f)
        )
        addView(more)
    }
}
