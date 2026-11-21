package com.azer.browser

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout

class ReaderModeLayout(context: Context) : LinearLayout(context) {

    val toolbar: LinearLayout
    val readerView: ReaderModeView

    init {
        orientation = VERTICAL

        toolbar = LinearLayout(context).apply {
            orientation = HORIZONTAL
        }

        readerView = ReaderModeView(context)

        addView(
            toolbar,
            LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        addView(
            readerView,
            LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )
    }

    fun showArticle(html: String) {
        readerView.display(html)
    }
}
