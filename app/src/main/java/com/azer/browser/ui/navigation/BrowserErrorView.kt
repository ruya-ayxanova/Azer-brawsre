package com.azer.browser.ui.navigation

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

object BrowserErrorView {

    fun create(
        context: Context,
        message: String,
        onRetry: () -> Unit
    ): LinearLayout {

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 24, 24, 24)
        layout.setBackgroundColor(Color.rgb(16, 24, 32))

        val title = TextView(context)
        title.text = "Sayfa açılamadı"
        title.textSize = 22f
        title.gravity = Gravity.CENTER
        title.setTextColor(Color.WHITE)

        val details = TextView(context)
        details.text = message
        details.textSize = 15f
        details.gravity = Gravity.CENTER
        details.setTextColor(Color.LTGRAY)

        val retry = Button(context)
        retry.text = "Tekrar dene"
        retry.setOnClickListener {
            onRetry()
        }

        layout.addView(title)
        layout.addView(details)
        layout.addView(retry)

        return layout
    }
}
