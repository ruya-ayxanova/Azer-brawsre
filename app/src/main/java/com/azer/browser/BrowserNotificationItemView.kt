package com.azer.browser

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BrowserNotificationItemView(
    context: Context,
    private val onOpen: (BrowserNotification) -> Unit,
    private val onDelete: (BrowserNotification) -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(16, 12, 12, 12)
    }

    fun bind(item: BrowserNotification) {
        removeAllViews()

        val content = LinearLayout(context)
        content.orientation = VERTICAL
        content.layoutParams = LayoutParams(
            0,
            LayoutParams.WRAP_CONTENT,
            1f
        )

        val title = TextView(context)
        title.text = if (item.read) {
            item.title
        } else {
            "● ${item.title}"
        }
        title.textSize = 16f

        val message = TextView(context)
        message.text = item.message
        message.textSize = 14f

        val host = TextView(context)
        host.text = item.host
        host.textSize = 12f

        val time = TextView(context)
        time.text = BrowserNotificationDateFormatter.format(
            item.createdAt
        )
        time.textSize = 11f

        content.addView(title)
        content.addView(message)
        content.addView(host)
        content.addView(time)

        content.setOnClickListener {
            onOpen(item)
        }

        addView(content)

        val deleteButton = TextView(context)
        deleteButton.text = "✕"
        deleteButton.textSize = 20f
        deleteButton.gravity = Gravity.CENTER
        deleteButton.setPadding(16, 8, 16, 8)

        deleteButton.setOnClickListener {
            onDelete(item)
        }

        addView(deleteButton)
    }
}
