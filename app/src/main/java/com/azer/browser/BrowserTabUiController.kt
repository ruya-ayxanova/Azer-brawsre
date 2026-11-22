package com.azer.browser

class BrowserTabUiController {

    fun createState(
        tabs: List<BrowserTab>
    ): BrowserTabUiState {

        val cards = BrowserTabUiMapper.mapAll(tabs)

        return BrowserTabUiState(
            tabs = cards,
            selectedTabId = tabs.firstOrNull {
                it.isActive
            }?.id,
            tabCount = tabs.size,
            showNewTabButton = true
        )
    }

    fun findTab(
        state: BrowserTabUiState,
        id: String
    ): BrowserTabCardData? {

        return state.tabs.find {
            it.id == id
        }
    }

    fun hasTabs(
        state: BrowserTabUiState
    ): Boolean {
        return state.tabs.isNotEmpty()
    }
}
