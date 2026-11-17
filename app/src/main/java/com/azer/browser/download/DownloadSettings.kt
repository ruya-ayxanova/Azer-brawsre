
package com.azer.browser.download

import android.content.Context

class DownloadSettings(context: Context) {

    private val preferences = context.getSharedPreferences(
        "azer_download_settings",
        Context.MODE_PRIVATE
    )

    fun setNotifications(enabled: Boolean) {
        preferences.edit()
            .putBoolean("notifications", enabled)
            .apply()
    }

    fun notificationsEnabled(): Boolean {
        return preferences.getBoolean("notifications", true)
    }
}
