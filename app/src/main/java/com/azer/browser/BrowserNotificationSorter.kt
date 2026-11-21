package com.azer.browser

object BrowserNotificationSorter {

    fun newest(
        items: List<BrowserNotification>
    ): List<BrowserNotification> {
        return items.sortedByDescending { it.createdAt }
    }

    fun oldest(
        items: List<BrowserNotification>
    ): List<BrowserNotification> {
        return items.sortedBy { it.createdAt }
    }

    fun unreadFirst(
        items: List<BrowserNotification>
    ): List<BrowserNotification> {
        return items.sortedWith(
            compareBy<BrowserNotification> { it.read }
                .thenByDescending { it.createdAt }
        )
    }
}
