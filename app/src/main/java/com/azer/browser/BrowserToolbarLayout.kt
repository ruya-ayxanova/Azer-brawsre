
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout

class BrowserToolbarLayout(context: Context) :
    LinearLayout(context) {

    val navigationArea = LinearLayout(context)
    val addressArea = LinearLayout(context)
    val progressView = BrowserProgressView(context)

    init {
        orientation = VERTICAL
        setBackgroundColor(Color.WHITE)

        navigationArea.orientation = HORIZONTAL
        navigationArea.gravity = Gravity.CENTER_VERTICAL

        addressArea.orientation = HORIZONTAL
        addressArea.gravity = Gravity.CENTER_VERTICAL
        addressArea.setPadding(8, 6, 8, 6)

        addView(
            navigationArea,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
        )

        addView(
            addressArea,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
        )

        addView(
            progressView,
            LayoutParams(
                LayoutParams.MATCH_PARENT,
                4
            )
        )
    }
}
