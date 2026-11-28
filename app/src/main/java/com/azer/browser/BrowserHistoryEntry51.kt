package com.azer.browser

data class BrowserHistoryEntry51(
    val url: String,
    val title: String = "",
    val visitedAt: Long = System.currentTimeMillis()
)
