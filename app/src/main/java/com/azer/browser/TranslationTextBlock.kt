package com.azer.browser

data class TranslationTextBlock(
    val id: Int,
    val originalText: String,
    var translatedText: String = "",
    val isTitle: Boolean = false
)
