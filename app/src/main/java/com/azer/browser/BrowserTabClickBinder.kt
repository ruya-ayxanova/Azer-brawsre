package com.azer.browser

import android.view.View

object BrowserTabClickBinder {

    fun bind(
        view: View,
        tabId: String,
        onSelect: (String) -> Unit
    ) {

        view.setOnClickListener {
            onSelect(tabId)
        }
    }

    fun bindNewTab(
        view: View,
        onNewTab: () -> Unit
    ) {

        view.setOnClickListener {
            onNewTab()
        }
    }
}
