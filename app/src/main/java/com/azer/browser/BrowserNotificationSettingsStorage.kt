package com.azer.browser

import android.content.Context

class BrowserNotificationSettingsStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_notification_settings",
        Context.MODE_PRIVATE
    )

    fun load(): BrowserNotificationSettings {
        return BrowserNotificationSettings(
            enabled = prefs.getBoolean("enabled", true),
            soundEnabled = prefs.getBoolean("sound", true),
            vibrationEnabled = prefs.getBoolean("vibration", true),
            saveHistory = prefs.getBoolean("save_history", true),
            maxNotifications = prefs.getInt("max_notifications", 300)
        )
    }

    fun save(settings: BrowserNotificationSettings) {
        prefs.edit()
            .putBoolean("enabled", settings.enabled)
            .putBoolean("sound", settings.soundEnabled)
            .putBoolean("vibration", settings.vibrationEnabled)
            .putBoolean("save_history", settings.saveHistory)
            .putInt("max_notifications", settings.maxNotifications)
            .apply()
    }
}
