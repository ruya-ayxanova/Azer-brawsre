
package com.azer.browser

import android.content.Context

class BrowserToolbarSettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_toolbar_settings",
        Context.MODE_PRIVATE
    )

    var showHomeButton: Boolean
        get() = prefs.getBoolean("show_home", true)
        set(value) {
            prefs.edit().putBoolean("show_home", value).apply()
        }

    var showShareButton: Boolean
        get() = prefs.getBoolean("show_share", true)
        set(value) {
            prefs.edit().putBoolean("show_share", value).apply()
        }

    var showSecurityIndicator: Boolean
        get() = prefs.getBoolean("show_security", true)
        set(value) {
            prefs.edit().putBoolean("show_security", value).apply()
        }
}
