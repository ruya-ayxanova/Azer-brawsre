package com.azer.browser

import android.content.Context

class TranslationController(context: Context) {

    private val preferences = TranslationPreferences(context)
    private val history = TranslationHistoryManager(context)

    var state: TranslationState = TranslationState.IDLE
        private set

    fun getSettings(): TranslationSettings {
        return preferences.getSettings()
    }

    fun setSourceLanguage(code: String) {
        if (TranslationValidator.isValidLanguage(code)) {
            preferences.setSourceLanguage(code)
        }
    }

    fun setTargetLanguage(code: String) {
        if (TranslationValidator.isValidLanguage(code) &&
            code != "auto"
        ) {
            preferences.setTargetLanguage(code)
        }
    }

    fun setAutoTranslate(enabled: Boolean) {
        preferences.setAutoTranslate(enabled)
    }

    fun setShowOriginal(enabled: Boolean) {
        preferences.setShowOriginal(enabled)
    }

    fun prepareRequest(text: String): TranslationRequest? {
        val settings = getSettings()

        val request = TranslationRequest(
            text = text,
            sourceLanguage = settings.sourceLanguage,
            targetLanguage = settings.targetLanguage
        )

        return if (TranslationValidator.validateRequest(request)) {
            state = TranslationState.PREPARING
            request
        } else {
            state = TranslationState.FAILED
            null
        }
    }

    fun saveResult(result: TranslationResult) {
        if (result.success) {
            history.save(result)
            state = TranslationState.COMPLETED
        } else {
            state = TranslationState.FAILED
        }
    }

    fun getHistory(): List<TranslationHistoryItem> {
        return history.getAll()
    }

    fun clearHistory() {
        history.clearHistory()
    }

    fun resetState() {
        state = TranslationState.IDLE
    }
}
