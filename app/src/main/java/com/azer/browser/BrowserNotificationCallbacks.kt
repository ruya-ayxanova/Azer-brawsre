package com.azer.browser

interface BrowserNotificationCallbacks {

    fun onNotificationClicked(
        notification: BrowserNotification
    )

    fun onNotificationDeleted(
        notification: BrowserNotification
    )

    fun onNotificationsCleared()

    fun onNotificationsChanged(
        notifications: List<BrowserNotification>
    )
}
