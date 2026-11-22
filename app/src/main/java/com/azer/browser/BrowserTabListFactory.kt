package com.azer.browser

import android.content.Context
import android.view.View
import android.widget.LinearLayout

object BrowserTabListFactory {

    fun create(
        context: Context
    ): LinearLayout {

        val list = LinearLayout(context)

        list.orientation = LinearLayout.VERTICAL
        list.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        list.tag = "browser_tab_list"

        return list
    }

    fun addCard(
        list: LinearLayout,
        card: View
    ) {
        list.addView(card)
    }

    fun clear(
        list: LinearLayout
    ) {
        list.removeAllViews()
    }
}
