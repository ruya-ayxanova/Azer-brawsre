package com.azer.browser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class BrowserSitePermissionStorage(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_site_permissions",
        Context.MODE_PRIVATE
    )

    fun save(items: List<BrowserSitePermission>) {
        val array = JSONArray()

        items.forEach {
            val obj = JSONObject()
            obj.put("host", it.host)
            obj.put("permission", it.permission.name)
            obj.put("allowed", it.allowed)
            obj.put("updatedAt", it.updatedAt)
            array.put(obj)
        }

        prefs.edit()
            .putString("items", array.toString())
            .apply()
    }

    fun load(): List<BrowserSitePermission> {
        return try {
            val array = JSONArray(
                prefs.getString("items", "[]")
            )

            val list = mutableListOf<BrowserSitePermission>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                list.add(
                    BrowserSitePermission(
                        host = obj.getString("host"),
                        permission = BrowserPermissionType.valueOf(
                            obj.getString("permission")
                        ),
                        allowed = obj.getBoolean("allowed"),
                        updatedAt = obj.optLong("updatedAt")
                    )
                )
            }

            list
        } catch (_: Exception) {
            emptyList()
        }
    }

    fun clear() {
        prefs.edit().clear().apply()
    }
}
