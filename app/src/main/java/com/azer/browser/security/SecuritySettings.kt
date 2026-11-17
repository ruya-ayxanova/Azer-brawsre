
package com.azer.browser.security

import android.content.Context

class SecuritySettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_security",
        Context.MODE_PRIVATE
    )

    var safeBrowsing: Boolean
        get() = prefs.getBoolean("safe_browsing", true)
        set(value) {
            prefs.edit().putBoolean("safe_browsing", value).apply()
        }

    var trackingProtection: Boolean
        get() = prefs.getBoolean("tracking_protection", true)
        set(value) {
            prefs.edit().putBoolean("tracking_protection", value).apply()
        }
}
