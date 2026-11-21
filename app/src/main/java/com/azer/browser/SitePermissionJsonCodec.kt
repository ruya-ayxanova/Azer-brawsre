package com.azer.browser

import org.json.JSONArray
import org.json.JSONObject

object SitePermissionJsonCodec {

    fun encode(
        records: List<SitePermissionRecord>
    ): String {
        val array = JSONArray()

        records.forEach { record ->
            val obj = JSONObject()

            obj.put("host", record.host)
            obj.put("type", record.type.name)
            obj.put("action", record.action.name)
            obj.put("updatedAt", record.updatedAt)

            array.put(obj)
        }

        return array.toString()
    }

    fun decode(json: String): List<SitePermissionRecord> {
        return try {
            val array = JSONArray(json)
            val result = mutableListOf<SitePermissionRecord>()

            for (i in 0 until array.length()) {
                val obj = array.getJSONObject(i)

                result.add(
                    SitePermissionRecord(
                        host = obj.getString("host"),
                        type = BrowserPermissionType.valueOf(
                            obj.getString("type")
                        ),
                        action = SitePermissionAction.valueOf(
                            obj.getString("action")
                        ),
                        updatedAt = obj.optLong("updatedAt")
                    )
                )
            }

            result
        } catch (_: Exception) {
            emptyList()
        }
    }
}
