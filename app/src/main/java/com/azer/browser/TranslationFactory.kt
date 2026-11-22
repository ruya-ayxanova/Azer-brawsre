package com.azer.browser

import android.content.Context

object TranslationFactory {

    fun createController(context: Context): TranslationController {
        return TranslationController(context)
    }

    fun createPreferences(context: Context): TranslationPreferences {
        return TranslationPreferences(context)
    }

    fun createHistory(context: Context): TranslationHistoryManager {
        return TranslationHistoryManager(context)
    }

    fun createLanguageAdapter(
        context: Context
    ): TranslationLanguageAdapter {
        return TranslationLanguageAdapter(context)
    }

    fun getLanguages(): List<TranslationLanguage> {
        return TranslationLanguageList.languages
    }
}
