
package com.azer.browser

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout

class BrowserToolbarController(
    private val context: Context,
    private val callbacks: BrowserToolbarCallbacks
) {

    private val actions = BrowserToolbarActions(callbacks)

    val layout = BrowserToolbarLayout(context)

    val addressInput = BrowserAddressInput(context) {
        actions.submitAddress(it)
    }

    val secureIndicator = BrowserSecureIndicator(context)

    private val navigation = BrowserNavigationButtons(
        context,
        { actions.back() },
        { actions.forward() },
        { actions.reload() }
    )

    private val homeButton = BrowserHomeButton(context) {
        actions.home()
    }

    private val shareButton = BrowserToolbarButton(
        context,
        "↗"
    ) {
        actions.share(addressInput.getAddress())
    }

    init {
        layout.navigationArea.addView(
            navigation,
            LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        )

        layout.navigationArea.addView(homeButton)

        layout.addressArea.addView(secureIndicator)

        layout.addressArea.addView(
            addressInput,
            LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        )

        layout.addressArea.addView(shareButton)
    }

    fun updateState(state: BrowserToolbarState) {
        addressInput.setAddress(state.url)
        secureIndicator.update(state.url)

        navigation.updateNavigation(
            state.canGoBack,
            state.canGoForward
        )

        if (state.isLoading) {
            layout.progressView.updateProgress(state.progress)
        } else {
            layout.progressView.hideLoading()
        }
    }

    fun setAddress(url: String) {
        addressInput.setAddress(url)
        secureIndicator.update(url)
    }

    fun updateProgress(progress: Int) {
        layout.progressView.updateProgress(progress)
    }
}
