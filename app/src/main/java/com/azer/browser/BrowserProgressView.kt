
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar

class BrowserProgressView(context: Context) : FrameLayout(context) {

    private val progressBar = ProgressBar(
        context,
        null,
        android.R.attr.progressBarStyleHorizontal
    )

    init {
        progressBar.max = 100
        progressBar.progress = 0
        progressBar.progressTintList =
            android.content.res.ColorStateList.valueOf(
                Color.rgb(27, 94, 65)
            )

        addView(
            progressBar,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                4
            )
        )

        visibility = View.GONE
    }

    fun updateProgress(value: Int) {
        progressBar.progress = value.coerceIn(0, 100)

        visibility = if (value >= 100) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    fun showLoading() {
        progressBar.progress = 0
        visibility = View.VISIBLE
    }

    fun hideLoading() {
        progressBar.progress = 100
        visibility = View.GONE
    }
}
