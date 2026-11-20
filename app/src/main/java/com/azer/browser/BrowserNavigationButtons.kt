
package com.azer.browser

import android.content.Context
import android.widget.LinearLayout

class BrowserNavigationButtons(
    context: Context,
    onBack: () -> Unit,
    onForward: () -> Unit,
    onReload: () -> Unit
) : LinearLayout(context) {

    val backButton = BrowserToolbarButton(
        context, "‹", onBack
    )

    val forwardButton = BrowserToolbarButton(
        context, "›", onForward
    )

    val reloadButton = BrowserToolbarButton(
        context, "↻", onReload
    )

    init {
        orientation = HORIZONTAL

        addView(backButton)
        addView(forwardButton)
        addView(reloadButton)
    }

    fun updateNavigation(
        canGoBack: Boolean,
        canGoForward: Boolean
    ) {
        backButton.setEnabledState(canGoBack)
        forwardButton.setEnabledState(canGoForward)
    }
}
