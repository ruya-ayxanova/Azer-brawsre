package com.azer.browser

object BrowserTabStateBuilder {

    fun build(
        tabs: List<BrowserTab>,
        privateMode: Boolean = false
    ): BrowserTabState {

        val active = tabs.find { it.isActive }

        return BrowserTabState(
            totalTabs = tabs.size,
            activeTabId = active?.id,
            hasTabs = tabs.isNotEmpty(),
            isPrivate = privateMode
        )
    }
}
