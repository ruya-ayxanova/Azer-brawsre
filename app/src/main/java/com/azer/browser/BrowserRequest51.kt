package com.azer.browser

data class BrowserRequest51(
    val url: String,
    val method: String = "GET",
    val headers: Map<String, String> = emptyMap(),
    val timestamp: Long = System.currentTimeMillis()
)
