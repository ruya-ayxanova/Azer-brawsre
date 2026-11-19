
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView

class BrowserTabStripView(
    context: Context,
    onSelect: (String) -> Unit,
    onClose: (String) -> Unit,
    private val onNewTab: () -> Unit
) : LinearLayout(context) {

    private val tabsContainer = LinearLayout(context)
    private val adapter = BrowserTabAdapter(
        context,
        onSelect,
        onClose
    )

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(8, 8, 8, 8)
        setBackgroundColor(Color.rgb(245, 247, 245))

        val scroll = HorizontalScrollView(context).apply {
            isHorizontalScrollBarEnabled = false
            layoutParams = LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT,
                1f
            )
        }

        tabsContainer.orientation = HORIZONTAL
        scroll.addView(tabsContainer)

        val addButton = TextView(context).apply {
            text = "+"
            textSize = 25f
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setPadding(12, 2, 12, 2)

            background = GradientDrawable().apply {
                setColor(Color.rgb(27, 94, 65))
                cornerRadius = 30f
            }

            setOnClickListener {
                onNewTab()
            }
        }

        addView(scroll)
        addView(addButton)
    }

    fun showTabs(tabs: List<BrowserTab>) {
        adapter.render(tabsContainer, tabs)
    }
}
