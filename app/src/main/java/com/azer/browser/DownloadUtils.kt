package com.azer.browser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

object DownloadStorage {

    private const val PREFS = "azer_download_storage"
    private const val KEY_DOWNLOADS = "downloads"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    fun saveDownloads(context: Context, items: List<DownloadItem>) {
        val array = JSONArray()

        items.forEach { item ->
            val obj = JSONObject()
            obj.put("id", item.id)
            obj.put("title", item.title)
            obj.put("url", item.url)
            obj.put("fileName", item.fileName)
            obj.put("filePath", item.filePath)
            obj.put("status", item.status.name)
            obj.put("progress", item.progress)
            obj.put("totalBytes", item.totalBytes)
            obj.put("downloadedBytes", item.downloadedBytes)
            obj.put("createdAt", item.createdAt)
            array.put(obj)
        }

        prefs(context).edit()
            .putString(KEY_DOWNLOADS, array.toString())
            .apply()
    }

    fun getDownloads(context: Context): MutableList<DownloadItem> {
        val result = mutableListOf<DownloadItem>()
        val raw = prefs(context).getString(KEY_DOWNLOADS, "[]") ?: "[]"

        try {
            val array = JSONArray(raw)

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                val status = try {
                    DownloadStatus.valueOf(
                        obj.optString("status", "PENDING")
                    )
                } catch (_: Exception) {
                    DownloadStatus.PENDING
                }

                result.add(
                    DownloadItem(
                        id = obj.optLong("id"),
                        title = obj.optString("title"),
                        url = obj.optString("url"),
                        fileName = obj.optString("fileName"),
                        filePath = obj.optString("filePath"),
                        status = status,
                        progress = obj.optInt("progress"),
                        totalBytes = obj.optLong("totalBytes"),
                        downloadedBytes = obj.optLong("downloadedBytes"),
                        createdAt = obj.optLong("createdAt")
                    )
                )
            }
        } catch (_: Exception) {
        }

        return result
    }
}
