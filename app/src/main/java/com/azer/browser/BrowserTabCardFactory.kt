package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

object BrowserTabCardFactory {

    fun create(
        context: Context,
        tab: BrowserTabCardData
    ): LinearLayout {

        val card = LinearLayout(context)

        card.orientation = LinearLayout.VERTICAL
        card.gravity = Gravity.CENTER_VERTICAL
        card.setPadding(24, 20, 24, 20)
        card.setBackgroundColor(
            if (tab.active) Color.rgb(225, 235, 225)
            else Color.WHITE
        )

        val title = TextView(context)
        title.text = tab.title
        title.textSize = 17f
        title.setTextColor(Color.BLACK)

        val url = TextView(context)
        url.text = tab.url.ifBlank {
            "Yeni sekme"
        }
        url.textSize = 12f
        url.setTextColor(Color.DKGRAY

)

        card.addView(title)
        card.addView(url)

        card.tag = tab.id

        return card
    }
}
