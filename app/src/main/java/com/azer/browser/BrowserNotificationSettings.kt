package com.azer.browser

data class BrowserNotificationSettings(
    val enabled: Boolean = true,
    val soundEnabled: Boolean = true,
    val vibrationEnabled: Boolean = true,
    val saveHistory: Boolean = true,
    val maxNotifications: Int = 300
)
