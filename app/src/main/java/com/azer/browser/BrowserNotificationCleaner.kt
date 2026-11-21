package com.azer.browser

class BrowserNotificationCleaner(
    private val repository: BrowserNotificationRepository,
    private val settings: BrowserNotificationSettingsManager
) {

    fun trim() {
        val max = settings.get().maxNotifications
        val items = repository.getAll()

        if (items.size <= max) return

        items.drop(max).forEach {
            repository.delete(it.id)
        }
    }

    fun clearAll() {
        repository.clear()
    }

    fun delete(item: BrowserNotification) {
        repository.delete(item.id)
    }
}
