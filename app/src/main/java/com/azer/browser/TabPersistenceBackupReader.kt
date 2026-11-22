package com.azer.browser

import org.json.JSONObject

object TabPersistenceBackupReader {

    fun read(
        json: String
    ): TabPersistenceSnapshot? {

        return try {

            val root = JSONObject(json)

            val version = root.optInt(
                "backupVersion",
                -1
            )

            if (version != TabPersistenceConstants.VERSION) {
                return null
            }

            val data = root.optString("data")

            if (data.isBlank()) return null

            TabPersistenceJsonDecoder.decode(data)

        } catch (e: Exception) {
            null
        }
    }
}
