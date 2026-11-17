
package com.azer.browser.adblock

import android.content.Context

class AdBlockSettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_adblock",
        Context.MODE_PRIVATE
    )

    var enabled: Boolean
        get() = prefs.getBoolean("enabled", true)
        set(value) {
            prefs.edit().putBoolean("enabled", value).apply()
        }
}
