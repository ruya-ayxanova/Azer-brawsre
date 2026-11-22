package com.azer.browser

data class TranslationSettings(
    val sourceLanguage: String = "auto",
    val targetLanguage: String = "tr",
    val autoTranslate: Boolean = false,
    val showOriginal: Boolean = true
)
