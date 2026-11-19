
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class HomePageAdapter(
    private val context: Context
) {

    fun render(
        container: LinearLayout,
        pages: List<HomePageItem>,
        onOpen: (String) -> Unit
    ) {
        container.removeAllViews()

        pages.forEach { page ->
            val row = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(14, 12, 14, 12)
                gravity = Gravity.CENTER_VERTICAL
                background = GradientDrawable().apply {
                    setColor(Color.WHITE)
                    cornerRadius = 12f
                }
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    bottomMargin = 8
                }

                setOnClickListener {
                    onOpen(page.url)
                }
            }

            val title = TextView(context).apply {
                text = page.title
                textSize = 15f
                typeface = Typeface.DEFAULT_BOLD
                setTextColor(Color.rgb(35, 35, 35))
                maxLines = 1
            }

            val address = TextView(context).apply {
                text = page.url
                textSize = 12f
                setTextColor(Color.GRAY)
                maxLines = 1
                setPadding(0, 4, 0, 0)
            }

            row.addView(title)
            row.addView(address)
            container.addView(row)
        }
    }
}
