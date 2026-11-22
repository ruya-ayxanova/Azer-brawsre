package com.azer.browser

data class BrowserTabState(
    val totalTabs: Int = 0,
    val activeTabId: String? = null,
    val hasTabs: Boolean = false,
    val isPrivate: Boolean = false
)
