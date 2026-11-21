package com.azer.browser

import android.content.Context

class BrowserPrivacyStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_privacy",
        Context.MODE_PRIVATE
    )

    fun getBoolean(key: String, default: Boolean): Boolean {
        return prefs.getBoolean(key, default)
    }

    fun setBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
