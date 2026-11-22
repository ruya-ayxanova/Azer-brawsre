package com.azer.browser

object TabPersistenceJsonUtils {

    fun isValidJson(text: String): Boolean {
        return try {
            org.json.JSONObject(text)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun safeDecode(
        text: String
    ): TabPersistenceSnapshot? {

        if (!isValidJson(text)) return null

        return TabPersistenceJsonDecoder.decode(text)
    }
}
