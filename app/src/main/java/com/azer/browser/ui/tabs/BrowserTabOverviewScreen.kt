package com.azer.browser.ui.tabs

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

object BrowserTabOverviewScreen {

    fun create(
        context: Context,
        entries: List<BrowserTabEntry>,
        onSelect: (Int) -> Unit,
        onClose: (Int) -> Unit,
        onNewTab: () -> Unit
    ): View {

        val root = LinearLayout(context)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(12, 12, 12, 12)
        root.setBackgroundColor(Color.rgb(16, 24, 32))

        val title = TextView(context)
        title.text = "Açık Sekmeler (${entries.size})"
        title.textSize = 23f
        title.setTextColor(Color.WHITE)
        title.setPadding(8, 12, 8, 12)

        root.addView(title)

        root.addView(
            BrowserTabOpenButton.create(context, onNewTab)
        )

        val scroll = ScrollView(context)
        val list = LinearLayout(context)
        list.orientation = LinearLayout.VERTICAL

        entries.forEach { entry ->

            val card = BrowserTabCardView.create(
                context,
                entry,
                onSelect = {
                    onSelect(entry.id)
                },
                onClose = {
                    onClose(entry.id)
                }
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(0, 8, 0, 8)

            list.addView(card, params)
        }

        scroll.addView(list)

        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        return root
    }
}
