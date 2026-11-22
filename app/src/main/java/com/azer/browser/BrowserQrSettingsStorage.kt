package com.azer.browser

import android.content.Context

class BrowserQrSettingsStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        BrowserQrConstants.PREFS_NAME,
        Context.MODE_PRIVATE
    )

    fun getSettings(): BrowserQrSettings {
        return BrowserQrSettings(
            saveHistory = prefs.getBoolean("save_history", true),
            autoOpenLinks = prefs.getBoolean("auto_open", false),
            vibrateOnScan = prefs.getBoolean("vibrate", true),
            showConfirmation = prefs.getBoolean("confirmation", true)
        )
    }

    fun save(settings: BrowserQrSettings) {
        prefs.edit()
            .putBoolean("save_history", settings.saveHistory)
            .putBoolean("auto_open", settings.autoOpenLinks)
            .putBoolean("vibrate", settings.vibrateOnScan)
            .putBoolean("confirmation", settings.showConfirmation)
            .apply()
    }
}
