
package com.azer.browser

import android.content.Context
import android.view.View
import android.widget.LinearLayout

class BrowserTabAdapter(
    private val context: Context,
    private val onSelect: (String) -> Unit,
    private val onClose: (String) -> Unit
) {

    fun render(
        container: LinearLayout,
        tabs: List<BrowserTab>
    ) {
        container.removeAllViews()

        tabs.forEach { tab ->
            val item = BrowserTabItemView(
                context,
                tab,
                onSelect,
                onClose
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = 8
            }

            container.addView(item, params)
        }
    }
}
