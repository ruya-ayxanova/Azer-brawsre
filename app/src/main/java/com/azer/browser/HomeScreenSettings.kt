
package com.azer.browser

import android.content.Context

class HomeScreenSettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_home_settings",
        Context.MODE_PRIVATE
    )

    var showShortcuts: Boolean
        get() = prefs.getBoolean("show_shortcuts", true)
        set(value) {
            prefs.edit().putBoolean("show_shortcuts", value).apply()
        }

    var showRecentPages: Boolean
        get() = prefs.getBoolean("show_recent_pages", true)
        set(value) {
            prefs.edit().putBoolean("show_recent_pages", value).apply()
        }

    var searchHint: String
        get() = prefs.getString(
            "search_hint",
            "Ara veya web adresi yaz"
        ) ?: "Ara veya web adresi yaz"
        set(value) {
            prefs.edit().putString("search_hint", value).apply()
        }
}
