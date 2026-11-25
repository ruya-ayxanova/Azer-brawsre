package com.azer.browser

import android.view.View
import android.widget.ProgressBar

class AzerProgressController43(
    private val progressBar: ProgressBar
) {

    fun update(progress: Int) {
        val value = progress.coerceIn(0, 100)
        progressBar.progress = value

        progressBar.visibility =
            if (value >= 100) View.GONE else View.VISIBLE
    }

    fun reset() {
        progressBar.progress = 0
        progressBar.visibility = View.VISIBLE
    }

    fun finish() {
        progressBar.progress = 100
        progressBar.visibility = View.GONE
    }
}
