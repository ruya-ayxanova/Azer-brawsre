
package com.azer.browser

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BrowserHistoryItemView(
    context: Context,
    private val onOpen: (BrowserHistoryEntry) -> Unit,
    private val onDelete: (BrowserHistoryEntry) -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(16, 12, 12, 12)
    }

    fun bind(entry: BrowserHistoryEntry) {
        removeAllViews()

        val content = LinearLayout(context)
        content.orientation = VERTICAL
        content.layoutParams = LayoutParams(
            0,
            LayoutParams.WRAP_CONTENT,
            1f
        )

        val title = TextView(context)
        title.text = entry.title
        title.textSize = 16f

        val url = TextView(context)
        url.text = entry.url
        url.textSize = 12f

        val time = TextView(context)
        time.text = BrowserHistoryDateHelper.formatFull(entry.visitedAt)
        time.textSize = 11f

        content.addView(title)
        content.addView(url)
        content.addView(time)

        content.setOnClickListener {
            onOpen(entry)
        }

        addView(content)

        val deleteButton = TextView(context)
        deleteButton.text = "✕"
        deleteButton.textSize = 20f
        deleteButton.gravity = Gravity.CENTER
        deleteButton.setPadding(16, 8, 16, 8)

        deleteButton.setOnClickListener {
            onDelete(entry)
        }

        addView(deleteButton)
    }
}
