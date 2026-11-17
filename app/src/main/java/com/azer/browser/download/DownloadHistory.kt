
package com.azer.browser.download

import android.content.Context

class DownloadHistory(context: Context) {

    private val preferences = context.getSharedPreferences(
        "azer_download_history",
        Context.MODE_PRIVATE
    )

    fun save(id: Long, url: String) {
        preferences.edit()
            .putString(id.toString(), url)
            .apply()
    }

    fun getAll(): Map<String, *> {
        return preferences.all
    }

    fun clear() {
        preferences.edit().clear().apply()
    }
}
