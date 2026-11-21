package com.azer.browser

import android.content.Context

class SitePermissionLocalStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_site_access_v29",
        Context.MODE_PRIVATE
    )

    fun read(): String {
        return prefs.getString("records", "[]") ?: "[]"
    }

    fun write(json: String) {
        prefs.edit()
            .putString("records", json)
            .apply()
    }

    fun clear() {
        prefs.edit()
            .remove("records")
            .apply()
    }
}
