package com.azer.browser

import android.content.Context

object DownloadSettings {

    private const val PREFS = "azer_download_settings"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    fun getWifiOnly(context: Context): Boolean {
        return prefs(context).getBoolean("wifi_only", false)
    }

    fun setWifiOnly(context: Context, enabled: Boolean) {
        prefs(context).edit()
            .putBoolean("wifi_only", enabled)
            .apply()
    }

    fun getNotificationEnabled(context: Context): Boolean {
        return prefs(context).getBoolean("notifications", true)
    }

    fun setNotificationEnabled(context: Context, enabled: Boolean) {
        prefs(context).edit()
            .putBoolean("notifications", enabled)
            .apply()
    }

    fun getDownloadFolder(context: Context): String {
        return prefs(context).getString(
            "download_folder",
            "Downloads/AzerBrowser"
        ) ?: "Downloads/AzerBrowser"
    }

    fun setDownloadFolder(context: Context, folder: String) {
        prefs(context).edit()
            .putString("download_folder", folder)
            .apply()
    }
}
