
package com.azer.browser.settings

import android.content.Context

class BrowserPreferences(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_browser_settings",
        Context.MODE_PRIVATE
    )

    var homePage: String
        get() = prefs.getString(
            "home_page",
            "https://www.google.com"
        ) ?: "https://www.google.com"
        set(value) {
            prefs.edit().putString("home_page", value).apply()
        }

    var darkMode: Boolean
        get() = prefs.getBoolean("dark_mode", false)
        set(value) {
            prefs.edit().putBoolean("dark_mode", value).apply()
        }

    var blockPopups: Boolean
        get() = prefs.getBoolean("block_popups", true)
        set(value) {
            prefs.edit().putBoolean("block_popups", value).apply()
        }
}
