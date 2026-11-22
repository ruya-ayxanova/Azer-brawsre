package com.azer.browser

data class TranslationResult(
    val originalText: String,
    val translatedText: String,
    val sourceLanguage: String,
    val targetLanguage: String,
    val success: Boolean,
    val errorMessage: String? = null
)
