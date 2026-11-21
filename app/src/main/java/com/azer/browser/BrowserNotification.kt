package com.azer.browser

data class BrowserNotification(
    val id: String,
    val title: String,
    val message: String,
    val host: String,
    val createdAt: Long = System.currentTimeMillis(),
    val read: Boolean = false
)
