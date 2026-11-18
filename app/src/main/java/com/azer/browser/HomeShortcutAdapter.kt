
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class HomeShortcutAdapter(
    private val context: Context
) {

    fun render(
        container: LinearLayout,
        shortcuts: List<HomeShortcut>,
        onOpen: (String) -> Unit
    ) {
        container.removeAllViews()

        shortcuts.forEach { shortcut ->
            val item = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                setPadding(8, 12, 8, 12)
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
                )
                setOnClickListener {
                    onOpen(shortcut.url)
                }
            }

            val icon = TextView(context).apply {
                text = shortcut.title.take(1).uppercase()
                textSize = 20f
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
                setTextColor(Color.WHITE)
                background = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(Color.rgb(27, 94, 65))
                }
                layoutParams = LinearLayout.LayoutParams(48, 48)
            }

            val title = TextView(context).apply {
                text = shortcut.title
                textSize = 12f
                setTextColor(Color.DKGRAY)
                gravity = Gravity.CENTER
                maxLines = 1
                setPadding(0, 6, 0, 0)
            }

            item.addView(icon)
            item.addView(title)
            container.addView(item)
        }
    }
}
