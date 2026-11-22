package com.azer.browser

import android.content.Context

class BrowserNetworkSettingsManager(context: Context) {

    private val preferences = BrowserNetworkPreferences(context)

    fun getSettings(): BrowserNetworkSettings {
        return preferences.getSettings()
    }

    fun update(settings: BrowserNetworkSettings) {
        preferences.save(settings)
    }

    fun setAutoReload(enabled: Boolean) {
        update(getSettings().copy(autoReloadOnReconnect = enabled))
    }

    fun setDataSaver(enabled: Boolean) {
        update(getSettings().copy(dataSaverEnabled = enabled))
    }

    fun setOfflineWarning(enabled: Boolean) {
        update(getSettings().copy(showOfflineWarning = enabled))
    }

    fun setMonitoring(enabled: Boolean) {
        update(getSettings().copy(monitorConnection = enabled))
    }
}
