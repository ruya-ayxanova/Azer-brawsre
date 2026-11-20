package com.azer.browser

import android.content.Context
import android.view.View
import android.widget.LinearLayout

class BookmarkListView(
    context: Context,
    private val onOpen: (Bookmark) -> Unit,
    private val onBookmarkMenu: (Bookmark, View) -> Unit
) : LinearLayout(context) {

    init {
        orientation = VERTICAL
    }

    fun setBookmarks(bookmarks: List<Bookmark>) {
        removeAllViews()

        bookmarks.forEach { bookmark ->
            val item = BookmarkItemView(
                context,
                onOpen,
                { selectedBookmark, anchor ->
                    onBookmarkMenu(selectedBookmark, anchor)
                }
            )

            item.bind(bookmark)

            addView(
                item,
                LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )
            )
        }
    }
}
