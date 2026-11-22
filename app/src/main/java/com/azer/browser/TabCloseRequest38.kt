package com.azer.browser

data class TabCloseRequest38(
    val tabId: String,
    val confirmRequired: Boolean = false,
    val closeRelatedTabs: Boolean = false
)
