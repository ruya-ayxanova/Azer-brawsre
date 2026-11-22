package com.azer.browser

sealed class BrowserTabUiAction {

    data object NewTab : BrowserTabUiAction()

    data class SelectTab(
        val tabId: String
    ) : BrowserTabUiAction()

    data class CloseTab(
        val tabId: String
    ) : BrowserTabUiAction()

    data object CloseAll : BrowserTabUiAction()
}
