package com.azer.browser.ui.bookmarks

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class BookmarkScreenView(
    context: Context,
    private val controller: BookmarkScreenController,
    private val onOpenBookmark: (String) -> Unit
) {

    private val ctx = context

    fun create(): View {
        val root = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.WHITE)
        }

        val header = TextView(ctx).apply {
            text = "⭐ Yer İmleri"
            textSize = 22f
            setTextColor(Color.BLACK)
            setPadding(20, 24, 20, 24)
        }

        root.addView(header)

        val scrollView = ScrollView(ctx)

        val listContainer = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
        }

        refresh(listContainer)

        scrollView.addView(listContainer)

        root.addView(
            scrollView,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        return root
    }

    private fun refresh(container: LinearLayout) {
        container.removeAllViews()

        val bookmarks = controller.getBookmarks()

        if (bookmarks.isEmpty()) {
            container.addView(BookmarkEmptyView.create(ctx))
            return
        }

        bookmarks.forEach { bookmark ->
            val row = BookmarkListItem.create(
                context = ctx,
                bookmark = bookmark,
                onOpen = { item ->
                    onOpenBookmark(item.url)
                },
                onDelete = { item ->
                    controller.removeBookmark(item.id)
                    refresh(container)
                }
            )

            container.addView(row)

            val divider = View(ctx).apply {
                setBackgroundColor(0xFFE0E0E0.toInt())
            }

            container.addView(
                divider,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1
                )
            )
        }
    }
}
