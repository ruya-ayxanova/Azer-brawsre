package com.azer.browser

data class BrowserSessionHistory40(
    val sessionId: String,
    val action: BrowserSessionAction40,
    val timestamp: Long,
    val description: String
)
