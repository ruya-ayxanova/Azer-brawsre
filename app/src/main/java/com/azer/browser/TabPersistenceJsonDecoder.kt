package com.azer.browser

import org.json.JSONObject

object TabPersistenceJsonDecoder {

    fun decode(
        json: String
    ): TabPersistenceSnapshot? {

        return try {

            val root = JSONObject(json)
            val array = root.optJSONArray("tabs")
                ?: return null

            val records = mutableListOf<TabPersistenceRecord>()

            for (i in 0 until array.length()) {

                val item = array.optJSONObject(i)
                    ?: continue

                val record = TabPersistenceRecord(
                    id = item.optString("id"),
                    title = item.optString(
                        "title",
                        "Yeni sekme"
                    ),
                    url = item.optString("url"),
                    isActive = item.optBoolean("active"),
                    createdAt = item.optLong("created"),
                    lastAccessedAt = item.optLong("accessed")
                )

                if (TabPersistenceValidator.isValid(record)) {
                    records.add(record)
                }
            }

            val validRecords =
                TabPersistenceValidator.validateRecords(records)

            TabPersistenceSnapshot(
                tabs = validRecords,
                activeTabId = root.optString(
                    "activeTabId"
                ).takeIf { it.isNotBlank() },
                savedAt = root.optLong("savedAt")
            )

        } catch (e: Exception) {
            null
        }
    }
}
