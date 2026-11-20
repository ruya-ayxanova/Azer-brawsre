
package com.azer.browser

import android.content.Context

class BrowserHistorySettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_history_settings",
        Context.MODE_PRIVATE
    )

    var enabled: Boolean
        get() = prefs.getBoolean("enabled", true)
        set(value) {
            prefs.edit().putBoolean("enabled", value).apply()
        }

    var maxEntries: Int
        get() = prefs.getInt("max_entries", 5000)
        set(value) {
            prefs.edit()
                .putInt("max_entries", value.coerceIn(100, 50000))
                .apply()
        }

    var saveTitles: Boolean
        get() = prefs.getBoolean("save_titles", true)
        set(value) {
            prefs.edit().putBoolean("save_titles", value).apply()
        }
}
