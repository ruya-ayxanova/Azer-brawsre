package com.azer.browser

import android.view.View
import android.widget.LinearLayout

object AzerToolbarButtonBinder43 {

    fun attach(
        toolbar: LinearLayout,
        button: View,
        widthDp: Int = 48
    ) {
        val context = toolbar.context

        val width = (
            widthDp * context.resources
                .displayMetrics.density
        ).toInt()

        toolbar.addView(
            button,
            LinearLayout.LayoutParams(
                width,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
    }
}
