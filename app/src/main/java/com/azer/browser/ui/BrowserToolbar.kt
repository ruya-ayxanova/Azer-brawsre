package com.azer.browser.ui

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

object BrowserToolbar {

    fun create(
        context: Context,
        onSearch: (String) -> Unit,
        onHome: () -> Unit
    ): LinearLayout {

        val bar = LinearLayout(context)
        bar.orientation = LinearLayout.HORIZONTAL
        bar.gravity = Gravity.CENTER_VERTICAL
        bar.setPadding(8, 8, 8, 8)
        bar.setBackgroundColor(BrowserTheme.surface)

        val home = Button(context)
        home.text = "⌂"
        home.setOnClickListener { onHome() }

        val address = EditText(context)
        address.hint = "Adres veya ara..."
        address.singleLine = true
        address.setTextColor(Color.WHITE)
        address.setHintTextColor(Color.LTGRAY)
        address.setBackgroundColor(Color.TRANSPARENT)
        address.setPadding(12, 4, 12, 4)

        val search = Button(context)
        search.text = "Git"
        search.setOnClickListener {
            onSearch(address.text.toString())
        }

        bar.addView(home, LinearLayout.LayoutParams(48, 48))
        bar.addView(
            address,
            LinearLayout.LayoutParams(0, 48, 1f)
        )
        bar.addView(search, LinearLayout.LayoutParams(60, 48))

        return bar
    }
}
