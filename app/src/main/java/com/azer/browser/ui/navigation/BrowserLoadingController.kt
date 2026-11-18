package com.azer.browser.ui.navigation

import android.view.View
import android.widget.ProgressBar

class BrowserLoadingController(
    private val progressBar: ProgressBar
) {

    fun update(progress: Int) {
        progressBar.progress = progress.coerceIn(0, 100)

        progressBar.visibility =
            if (progress >= 100) View.GONE
            else View.VISIBLE
    }

    fun start() {
        progressBar.progress = 0
        progressBar.visibility = View.VISIBLE
    }

    fun finish() {
        progressBar.progress = 100
        progressBar.visibility = View.GONE
    }
}
