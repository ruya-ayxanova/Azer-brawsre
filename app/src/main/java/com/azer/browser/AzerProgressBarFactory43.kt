package com.azer.browser

import android.content.Context
import android.widget.ProgressBar

object AzerProgressBarFactory43 {

    fun create(context: Context): ProgressBar {
        return ProgressBar(
            context,
            null,
            android.R.attr.progressBarStyleHorizontal
        ).apply {
            max = 100
            progress = 0
        }
    }
}
