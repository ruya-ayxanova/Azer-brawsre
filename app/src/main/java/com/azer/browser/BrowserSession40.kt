package com.azer.browser

data class BrowserSession40(
    val sessionId: String,
    val createdAt: Long,
    val updatedAt: Long,
    val activeTabId: String?,
    val tabIds: List<String>,
    val isPrivate: Boolean = false
)
