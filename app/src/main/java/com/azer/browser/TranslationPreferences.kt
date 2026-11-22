package com.azer.browser

import android.content.Context

class TranslationPreferences(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_translation_settings",
        Context.MODE_PRIVATE
    )

    fun getSourceLanguage(): String {
        return prefs.getString("source_language", "auto") ?: "auto"
    }

    fun setSourceLanguage(code: String) {
        prefs.edit().putString("source_language", code).apply()
    }

    fun getTargetLanguage(): String {
        return prefs.getString("target_language", "tr") ?: "tr"
    }

    fun setTargetLanguage(code: String) {
        prefs.edit().putString("target_language", code).apply()
    }

    fun isAutoTranslateEnabled(): Boolean {
        return prefs.getBoolean("auto_translate", false)
    }

    fun setAutoTranslate(enabled: Boolean) {
        prefs.edit().putBoolean("auto_translate", enabled).apply()
    }

    fun isShowOriginalEnabled(): Boolean {
        return prefs.getBoolean("show_original", true)
    }

    fun setShowOriginal(enabled: Boolean) {
        prefs.edit().putBoolean("show_original", enabled).apply()
    }

    fun getSettings(): TranslationSettings {
        return TranslationSettings(
            sourceLanguage = getSourceLanguage(),
            targetLanguage = getTargetLanguage(),
            autoTranslate = isAutoTranslateEnabled(),
            showOriginal = isShowOriginalEnabled()
        )
    }
}
