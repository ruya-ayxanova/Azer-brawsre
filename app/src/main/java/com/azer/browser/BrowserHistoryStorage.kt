
package com.azer.browser

import android.content.Context

class BrowserHistoryStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_browser_history",
        Context.MODE_PRIVATE
    )

    fun save(json: String) {
        prefs.edit()
            .putString("history_data", json)
            .apply()
    }

    fun load(): String {
        return prefs.getString("history_data", "[]") ?: "[]"
    }

    fun clear() {
        prefs.edit()
            .remove("history_data")
            .apply()
    }
}
