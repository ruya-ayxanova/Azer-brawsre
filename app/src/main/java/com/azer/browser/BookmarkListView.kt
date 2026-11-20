
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class BookmarkListView(
    context: Context,
    private val onOpen: (Bookmark) -> Unit,
    private val onMore: (Bookmark) -> Unit
) : ScrollView(context) {

    private val list = LinearLayout(context)

    init {
        isFillViewport = true
        setBackgroundColor(Color.rgb(245, 247, 245))

        list.orientation = LinearLayout.VERTICAL
        list.setPadding(12, 12, 12, 12)

        addView(list)
    }

    fun showBookmarks(items: List<Bookmark>) {
        list.removeAllViews()

        if (items.isEmpty()) {
            val empty = TextView(context).apply {
                text = "Bu klasörde henüz yer imi yok."
                textSize = 14f
                setTextColor(Color.GRAY)
                setPadding(12, 24, 12, 24)
            }

            list.addView(empty)
            return
        }

        items.forEach { bookmark ->
            val item = BookmarkItemView(
                context,
                bookmark,
                onOpen,
                onMore
            )

            val params = LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = 8
            }

            list.addView(item, params)
        }
    }
}
