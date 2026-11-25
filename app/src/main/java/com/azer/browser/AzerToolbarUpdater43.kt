package com.azer.browser

import android.widget.Button
import android.widget.EditText

class AzerToolbarUpdater43(
    private val address: EditText,
    private val back: Button,
    private val forward: Button,
    private val tabs: Button
) {

    fun updateAddress(url: String) {
        address.setText(url)
    }

    fun updateNavigation(
        canGoBack: Boolean,
        canGoForward: Boolean
    ) {
        back.isEnabled = canGoBack
        forward.isEnabled = canGoForward
    }

    fun updateTabCount(count: Int) {
        tabs.text = count.toString()
    }
}
