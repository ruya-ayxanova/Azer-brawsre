
package com.azer.browser

import android.content.Context
import android.view.View
import android.widget.LinearLayout

class BrowserHistoryListView(
    context: Context,
    private val onOpen: (BrowserHistoryEntry) -> Unit,
    private val onDelete: (BrowserHistoryEntry) -> Unit
) : LinearLayout(context) {

    init {
        orientation = VERTICAL
    }

    fun setEntries(entries: List<BrowserHistoryEntry>) {
        removeAllViews()

        entries.forEach { entry ->
            val item = BrowserHistoryItemView(
                context,
                onOpen,
                onDelete
            )

            item.bind(entry)

            addView(
                item,
                LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )
            )
        }
    }

    fun showEmptyMessage(message: String = "Geçmiş boş") {
        removeAllViews()

        val text = android.widget.TextView(context)
        text.text = message
        text.textSize = 16f
        text.gravity = View.TEXT_ALIGNMENT_CENTER

        addView(
            text,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
        )
    }
}
