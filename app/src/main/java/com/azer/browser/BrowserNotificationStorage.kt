package com.azer.browser

import android.content.Context

class BrowserNotificationStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_notifications",
        Context.MODE_PRIVATE
    )

    fun save(json: String) {
        prefs.edit().putString("notification_data", json).apply()
    }

    fun load(): String {
        return prefs.getString("notification_data", "[]") ?: "[]"
    }

    fun clear() {
        prefs.edit().remove("notification_data").apply()
    }
}
