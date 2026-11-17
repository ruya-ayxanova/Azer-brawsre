
package com.azer.browser.media

import android.content.Context

class MediaDownloadHistory(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_media_download_history",
        Context.MODE_PRIVATE
    )

    fun save(id: Long, url: String) {
        prefs.edit()
            .putString(id.toString(), url)
            .apply()
    }

    fun getAll(): Map<String, *> {
        return prefs.all
    }

    fun remove(id: Long) {
        prefs.edit()
            .remove(id.toString())
            .apply()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
