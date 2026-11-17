package com.azer.browser.ui

import android.content.Context
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

object TabScreen {

    fun create(
        context: Context,
        tabCount: Int,
        onNewTab: () -> Unit,
        onPrivateTab: () -> Unit
    ): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(20, 20, 20, 20)
        layout.setBackgroundColor(BrowserTheme.background)

        val title = TextView(context)
        title.text = "Sekmeler"
        title.textSize = 25f
        title.setTextColor(BrowserTheme.text)

        val count = TextView(context)
        count.text = "Açık sekme sayısı: $tabCount"
        count.textSize = 17f
        count.setTextColor(BrowserTheme.secondaryText)

        val newTab = Button(context)
        newTab.text = "Yeni Sekme Aç"
        newTab.setOnClickListener { onNewTab() }

        val privateTab = Button(context)
        privateTab.text = "Gizli Sekme"
        privateTab.setOnClickListener { onPrivateTab() }

        layout.addView(title)
        layout.addView(count)
        layout.addView(newTab)
        layout.addView(privateTab)

        return layout
    }
}
