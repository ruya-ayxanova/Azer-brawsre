package com.azer.browser

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class BookmarkItemView(
    context: Context,
    private val onOpen: (Bookmark) -> Unit,
    private val onMore: (Bookmark, TextView) -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(16, 12, 8, 12)
    }

    fun bind(bookmark: Bookmark) {
        removeAllViews()

        val content = LinearLayout(context)
        content.orientation = VERTICAL
        content.layoutParams = LayoutParams(
            0,
            LayoutParams.WRAP_CONTENT,
            1f
        )

        val title = TextView(context)
        title.text = bookmark.title
        title.textSize = 16f

        val url = TextView(context)
        url.text = bookmark.url
        url.textSize = 12f

        content.addView(title)
        content.addView(url)

        content.setOnClickListener {
            onOpen(bookmark)
        }

        addView(content)

        val moreButton = TextView(context)
        moreButton.text = "⋮"
        moreButton.textSize = 26f
        moreButton.gravity = Gravity.CENTER
        moreButton.setPadding(16, 0, 16, 0)

        moreButton.setOnClickListener {
            onMore(bookmark, moreButton)
        }

        addView(moreButton)
    }
}
