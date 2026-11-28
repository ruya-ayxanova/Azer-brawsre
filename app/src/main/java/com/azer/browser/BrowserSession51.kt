package com.azer.browser

data class BrowserSession51(
    val sessionId: String,
    val currentUrl: String = "",
    val openedAt: Long = System.currentTimeMillis(),
    val lastActivity: Long = System.currentTimeMillis(),
    val privateMode: Boolean = false
)
