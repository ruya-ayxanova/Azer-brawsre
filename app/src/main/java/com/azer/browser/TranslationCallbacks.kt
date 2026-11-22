package com.azer.browser

interface TranslationCallbacks {

    fun onTranslationStarted()

    fun onTranslationCompleted(result: TranslationResult)

    fun onTranslationFailed(message: String)

    fun onLanguageChanged(languageCode: String)
}
