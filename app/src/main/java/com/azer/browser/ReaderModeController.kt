package com.azer.browser

import android.content.Context

class ReaderModeController(context: Context) {

    private val preferences = ReaderModePreferences(context)

    private var currentArticle: ReaderArticle? = null

    fun prepare(
        title: String,
        html: String,
        url: String
    ): ReaderArticle {
        val article = ReaderArticleFactory.create(title, html, url)
        currentArticle = article
        return article
    }

    fun getArticle(): ReaderArticle? = currentArticle

    fun getSettings(): ReaderModeSettings = preferences.getSettings()

    fun increaseFont() {
        preferences.setFontSize(
            (preferences.getFontSize() + 1).coerceAtMost(36)
        )
    }

    fun decreaseFont() {
        preferences.setFontSize(
            (preferences.getFontSize() - 1).coerceAtLeast(12)
        )
    }

    fun toggleDarkMode() {
        preferences.setDarkMode(!preferences.isDarkMode())
    }

    fun toggleSerifFont() {
        preferences.setSerifFont(!preferences.isSerifFont())
    }

    fun setLineSpacing(value: Float) {
        preferences.setLineSpacing(value)
    }

    fun resetSettings() {
        preferences.setFontSize(18)
        preferences.setLineSpacing(1.5f)
        preferences.setDarkMode(false)
        preferences.setSerifFont(false)
    }

    fun render(): String? {
        val article = currentArticle ?: return null
        return ReaderModeHtmlBuilder.build(article, getSettings())
    }
}
