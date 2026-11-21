package com.azer.browser

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BrowserNotificationListView(
    context: Context,
    private val onOpen: (BrowserNotification) -> Unit,
    private val onDelete: (BrowserNotification) -> Unit
) : LinearLayout(context) {

    init {
        orientation = VERTICAL
    }

    fun submit(items: List<BrowserNotification>) {
        removeAllViews()

        if (items.isEmpty()) {
            val empty = TextView(context)
            empty.text = "Bildirim bulunmuyor"
            empty.gravity = Gravity.CENTER
            empty.textSize = 16f

            addView(
                empty,
                LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )
            )
            return
        }

        items.forEach { item ->
            val view = BrowserNotificationItemView(
                context,
                onOpen,
                onDelete
            )

            view.bind(item)

            addView(
                view,
                LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )
            )
        }
    }
}
