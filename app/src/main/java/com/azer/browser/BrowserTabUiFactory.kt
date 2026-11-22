package com.azer.browser

object BrowserTabUiFactory {

    fun createController(): BrowserTabUiController {
        return BrowserTabUiController()
    }

    fun createState(
        tabs: List<BrowserTab>
    ): BrowserTabUiState {

        return BrowserTabUiMapperState.build(tabs)
    }
}

object BrowserTabUiMapperState {

    fun build(
        tabs: List<BrowserTab>
    ): BrowserTabUiState {

        val active = tabs.firstOrNull {
            it.isActive
        }

        return BrowserTabUiState(
            tabs = BrowserTabUiMapper.mapAll(tabs),
            selectedTabId = active?.id,
            tabCount = tabs.size,
            showNewTabButton = true
        )
    }
}
