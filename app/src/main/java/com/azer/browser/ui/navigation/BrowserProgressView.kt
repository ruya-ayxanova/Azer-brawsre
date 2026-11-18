package com.azer.browser.ui.navigation

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ProgressBar

object BrowserProgressView {

    fun create(context: Context): ProgressBar {
        return ProgressBar(
            context,
            null,
            android.R.attr.progressBarStyleHorizontal
        ).apply {
            max = 100
            progress = 0
            visibility = View.GONE
            progressTintList =
                android.content.res.ColorStateList.valueOf(
                    Color.rgb(0, 180, 150)
                )
        }
    }
}
