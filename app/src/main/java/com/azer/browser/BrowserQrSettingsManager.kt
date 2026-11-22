package com.azer.browser

import android.content.Context

class BrowserQrSettingsManager(context: Context) {

    private val storage = BrowserQrSettingsStorage(context)

    fun get(): BrowserQrSettings {
        return storage.getSettings()
    }

    fun update(settings: BrowserQrSettings) {
        storage.save(settings)
    }

    fun setAutoOpen(enabled: Boolean) {
        val current = get()
        update(current.copy(autoOpenLinks = enabled))
    }

    fun setSaveHistory(enabled: Boolean) {
        val current = get()
        update(current.copy(saveHistory = enabled))
    }

    fun setVibration(enabled: Boolean) {
        val current = get()
        update(current.copy(vibrateOnScan = enabled))
    }

    fun setConfirmation(enabled: Boolean) {
        val current = get()
        update(current.copy(showConfirmation = enabled))
    }
}
