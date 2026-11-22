package com.azer.browser

import android.content.Context
import android.view.View
import android.widget.ProgressBar

object BrowserTabLoadingIndicator {

    fun create(
        context: Context,
        loading: Boolean
    ): ProgressBar {

        val progress = ProgressBar(context)

        progress.isIndeterminate = true

        progress.visibility =
            if (loading) View.VISIBLE
            else View.GONE

        return progress
    }

    fun update(
        progress: ProgressBar,
        loading: Boolean
    ) {

        progress.visibility =
            if (loading) View.VISIBLE
            else View.GONE
    }
}
