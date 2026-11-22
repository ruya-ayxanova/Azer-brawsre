package com.azer.browser

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class TranslationHistoryRepository(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_translation_history",
        Context.MODE_PRIVATE
    )

    fun getHistory(): List<TranslationHistoryItem> {
        val json = prefs.getString("history", "[]") ?: "[]"
        val result = mutableListOf<TranslationHistoryItem>()

        try {
            val array = JSONArray(json)

            for (i in 0 until array.length()) {
                val item = array.getJSONObject(i)

                result.add(
                    TranslationHistoryItem(
                        originalText = item.optString("original"),
                        translatedText = item.optString("translated"),
                        sourceLanguage = item.optString("source"),
                        targetLanguage = item.optString("target"),
                        timestamp = item.optLong("timestamp")
                    )
                )
            }
        } catch (_: Exception) {
        }

        return result
    }

    fun add(item: TranslationHistoryItem) {
        val history = getHistory().toMutableList()
        history.add(0, item)

        val limited = history.take(100)
        val array = JSONArray()

        limited.forEach {
            array.put(
                JSONObject().apply {
                    put("original", it.originalText)
                    put("translated", it.translatedText)
                    put("source", it.sourceLanguage)
                    put("target", it.targetLanguage)
                    put("timestamp", it.timestamp)
                }
            )
        }

        prefs.edit().putString("history", array.toString()).apply()
    }

    fun clear() {
        prefs.edit().remove("history").apply()
    }
}
