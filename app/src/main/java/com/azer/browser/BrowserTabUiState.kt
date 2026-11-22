package com.azer.browser

data class BrowserTabUiState(
    val tabs: List<BrowserTabCardData> = emptyList(),
    val selectedTabId: String? = null,
    val tabCount: Int = 0,
    val showNewTabButton: Boolean = true
)
