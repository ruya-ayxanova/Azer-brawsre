package com.azer.browser

object ReaderModeValidator {

    fun isValid(article: ReaderArticle): Boolean {
        return article.content.trim().length >= 100
    }

    fun validateFontSize(size: Int): Int {
        return size.coerceIn(12, 36)
    }

    fun validateLineSpacing(value: Float): Float {
        return value.coerceIn(1.0f, 2.5f)
    }
}
