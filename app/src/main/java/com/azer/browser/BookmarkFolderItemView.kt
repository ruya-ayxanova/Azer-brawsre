
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class BookmarkFolderItemView(
    context: Context,
    private val folder: BookmarkFolder,
    private val count: Int,
    private val onClick: (BookmarkFolder) -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(14, 12, 14, 12)

        background = GradientDrawable().apply {
            setColor(Color.rgb(235, 242, 237))
            cornerRadius = 16f
        }

        val name = TextView(context).apply {
            text = "📁 ${folder.name}"
            textSize = 14f
            setTextColor(Color.rgb(27, 94, 65))
        }

        val total = TextView(context).apply {
            text = count.toString()
            textSize = 13f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
        }

        addView(
            name,
            LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f)
        )
        addView(total)

        setOnClickListener {
            onClick(folder)
        }
    }
}
