
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BrowserTabItemView(
    context: Context,
    private val tab: BrowserTab,
    private val onSelect: (String) -> Unit,
    private val onClose: (String) -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(12, 8, 8, 8)

        background = GradientDrawable().apply {
            setColor(
                if (tab.isActive) {
                    Color.rgb(27, 94, 65)
                } else {
                    Color.rgb(230, 235, 231)
                }
            )
            cornerRadius = 18f
        }

        val title = TextView(context).apply {
            text = tab.title.ifBlank { "Yeni sekme" }
            textSize = 13f
            maxLines = 1
            setTextColor(
                if (tab.isActive) Color.WHITE else Color.DKGRAY
            )
            typeface = if (tab.isActive) {
                Typeface.DEFAULT_BOLD
            } else {
                Typeface.DEFAULT
            }

            setOnClickListener {
                onSelect(tab.id)
            }
        }

        val close = TextView(context).apply {
            text = "×"
            textSize = 21f
            setPadding(10, 0, 4, 0)
            setTextColor(
                if (tab.isActive) Color.WHITE else Color.DKGRAY
            )
            gravity = Gravity.CENTER

            setOnClickListener {
                onClose(tab.id)
            }
        }

        addView(
            title,
            LayoutParams(130, LayoutParams.WRAP_CONTENT)
        )

        addView(close)
        
        setOnClickListener {
            onSelect(tab.id)
        }
    }
}
