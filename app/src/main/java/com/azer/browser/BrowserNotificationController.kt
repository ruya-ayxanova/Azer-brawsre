package com.azer.browser

import android.content.Context

class BrowserNotificationController(context: Context) {

    val repository = BrowserNotificationRepository(context)

    private val settings =
        BrowserNotificationSettingsManager(context)

    private val cleaner = BrowserNotificationCleaner(
        repository,
        settings
    )

    fun getAll(): List<BrowserNotification> {
        return BrowserNotificationSorter.newest(
            repository.getAll()
        )
    }

    fun search(query: String): List<BrowserNotification> {
        return BrowserNotificationSearch.search(
            getAll(),
            query
        )
    }

    fun add(
        title: String,
        message: String,
        host: String
    ): BrowserNotification? {
        if (!settings.get().enabled) return null

        val item = repository.add(
            BrowserNotificationValidator.cleanTitle(title),
            BrowserNotificationValidator.cleanMessage(message),
            BrowserNotificationValidator.cleanHost(host)
        )

        cleaner.trim()
        return item
    }

    fun markRead(id: String) {
        repository.markRead(id)
    }

    fun delete(id: String) {
        repository.delete(id)
    }

    fun clearAll() {
        cleaner.clearAll()
    }

    fun unreadCount(): Int {
        return repository.unreadCount()
    }

    fun getSettings(): BrowserNotificationSettings {
        return settings.get()
    }

    fun saveSettings(value: BrowserNotificationSettings) {
        settings.save(value)
    }
}
