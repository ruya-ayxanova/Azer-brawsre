package com.azer.browser

import android.content.Context
import android.widget.HorizontalScrollView
import android.widget.LinearLayout

class BookmarkFolderListView(
    context: Context,
    private val onSelect: (BookmarkFolder) -> Unit
) : HorizontalScrollView(context) {

    private val container = LinearLayout(context)

    init {
        isHorizontalScrollBarEnabled = false
        container.orientation = LinearLayout.HORIZONTAL
        container.setPadding(8, 8, 8, 8)
        addView(container)
    }

    fun showFolders(
        folders: List<BookmarkFolder>,
        bookmarks: List<Bookmark>
    ) {
        container.removeAllViews()

        folders.forEach { folder ->
            val count = bookmarks.count {
                it.folderId == folder.id
            }

            val item = BookmarkFolderItemView(
                context,
                folder,
                count,
                onSelect
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = 8
            }

            container.addView(item, params)
        }
    }
}
