package com.azer.browser

data class AzerSearchHistoryItem42(
    val query: String,
    val url: String,
    val timestamp: Long =
        System.currentTimeMillis()
)
