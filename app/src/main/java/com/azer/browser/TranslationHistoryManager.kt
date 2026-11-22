package com.azer.browser

import android.content.Context

class TranslationHistoryManager(context: Context) {

    private val repository = TranslationHistoryRepository(context)

    fun save(result: TranslationResult) {
        if (!result.success) return

        repository.add(
            TranslationHistoryItem(
                originalText = result.originalText,
                translatedText = result.translatedText,
                sourceLanguage = result.sourceLanguage,
                targetLanguage = result.targetLanguage
            )
        )
    }

    fun getAll(): List<TranslationHistoryItem> {
        return repository.getHistory()
    }

    fun clearHistory() {
        repository.clear()
    }
}
