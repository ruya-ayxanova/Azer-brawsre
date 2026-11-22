package com.azer.browser

class BrowserTabUiEventHandler(
    private val onAction: (BrowserTabUiAction) -> Unit
) {

    fun onNewTab() {
        onAction(
            BrowserTabUiAction.NewTab
        )
    }

    fun onSelectTab(id: String) {
        onAction(
            BrowserTabUiAction.SelectTab(id)
        )
    }

    fun onCloseTab(id: String) {
        onAction(
            BrowserTabUiAction.CloseTab(id)
        )
    }

    fun onCloseAll() {
        onAction(
            BrowserTabUiAction.CloseAll
        )
    }
}
