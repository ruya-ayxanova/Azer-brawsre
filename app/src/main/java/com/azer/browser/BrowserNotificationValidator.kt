package com.azer.browser

object BrowserNotificationValidator {

    fun isValid(item: BrowserNotification): Boolean {
        return item.id.isNotBlank() &&
            item.title.isNotBlank() &&
            item.host.isNotBlank()
    }

    fun cleanTitle(title: String): String {
        return title.trim().ifBlank {
            "Yeni bildirim"
        }
    }

    fun cleanMessage(message: String): String {
        return message.trim()
    }

    fun cleanHost(host: String): String {
        return host.trim().lowercase()
    }
}
