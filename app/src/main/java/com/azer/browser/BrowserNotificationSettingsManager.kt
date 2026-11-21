package com.azer.browser

import android.content.Context

class BrowserNotificationSettingsManager(context: Context) {

    private val storage = BrowserNotificationSettingsStorage(context)

    fun get(): BrowserNotificationSettings {
        return storage.load()
    }

    fun save(settings: BrowserNotificationSettings) {
        storage.save(settings.copy(
            maxNotifications = settings.maxNotifications.coerceIn(10, 5000)
        ))
    }

    fun setEnabled(enabled: Boolean) {
        save(get().copy(enabled = enabled))
    }

    fun setSoundEnabled(enabled: Boolean) {
        save(get().copy(soundEnabled = enabled))
    }

    fun setVibrationEnabled(enabled: Boolean) {
        save(get().copy(vibrationEnabled = enabled))
    }
}
