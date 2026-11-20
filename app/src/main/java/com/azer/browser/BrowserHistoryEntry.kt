
package com.azer.browser

data class BrowserHistoryEntry(
    val id: String,
    val title: String,
    val url: String,
    val visitedAt: Long,
    val visitCount: Int = 1
)
