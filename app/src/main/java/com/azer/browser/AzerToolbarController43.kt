package com.azer.browser

import android.widget.Button
import android.widget.EditText

class AzerToolbarController43(
    private val address: EditText,
    private val back: Button,
    private val forward: Button,
    private val tabs: Button
) {

    private val updater =
        AzerToolbarUpdater43(
            address,
            back,
            forward,
            tabs
        )

    private val stateManager =
        AzerToolbarStateManager43()

    fun setAddress(url: String) {
        updater.updateAddress(url)
        stateManager.updateAddress(url)
    }

    fun setNavigation(
        canGoBack: Boolean,
        canGoForward: Boolean
    ) {
        updater.updateNavigation(
            canGoBack,
            canGoForward
        )

        stateManager.updateNavigation(
            canGoBack,
            canGoForward
        )
    }

    fun setTabCount(count: Int) {
        updater.updateTabCount(count)
    }

    fun getState(): AzerBrowserToolbarState43 {
        return stateManager.getState()
    }
}
