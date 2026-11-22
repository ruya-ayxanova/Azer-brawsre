package com.azer.browser

import android.content.Context

class BrowserNetworkPreferences(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_network_settings",
        Context.MODE_PRIVATE
    )

    fun getSettings(): BrowserNetworkSettings {
        return BrowserNetworkSettings(
            showOfflineWarning = prefs.getBoolean("offline_warning", true),
            autoReloadOnReconnect = prefs.getBoolean("auto_reload", false),
            dataSaverEnabled = prefs.getBoolean("data_saver", false),
            monitorConnection = prefs.getBoolean("monitor", true)
        )
    }

    fun save(settings: BrowserNetworkSettings) {
        prefs.edit()
            .putBoolean("offline_warning", settings.showOfflineWarning)
            .putBoolean("auto_reload", settings.autoReloadOnReconnect)
            .putBoolean("data_saver", settings.dataSaverEnabled)
            .putBoolean("monitor", settings.monitorConnection)
            .apply()
    }
}
