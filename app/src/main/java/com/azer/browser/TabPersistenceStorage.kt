package com.azer.browser

import android.content.Context

class TabPersistenceStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        TabPersistenceConstants.PREFS_NAME,
        Context.MODE_PRIVATE
    )

    fun saveJson(json: String): Boolean {
        return prefs.edit()
            .putString(TabPersistenceConstants.KEY_TABS, json)
            .commit()
    }

    fun getJson(): String? {
        return prefs.getString(
            TabPersistenceConstants.KEY_TABS,
            null
        )
    }

    fun saveActiveTab(id: String?) {
        prefs.edit()
            .putString(
                TabPersistenceConstants.KEY_ACTIVE_TAB,
                id ?: ""
            )
            .apply()
    }

    fun getActiveTab(): String? {
        return prefs.getString(
            TabPersistenceConstants.KEY_ACTIVE_TAB,
            ""
        )?.takeIf { it.isNotBlank() }
    }

    fun saveTime(time: Long) {
        prefs.edit()
            .putLong(
                TabPersistenceConstants.KEY_SAVED_TIME,
                time
            )
            .apply()
    }

    fun getSavedTime(): Long {
        return prefs.getLong(
            TabPersistenceConstants.KEY_SAVED_TIME,
            0L
        )
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
