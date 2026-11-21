package com.azer.browser

import android.content.Context

class ReaderModeManager(context: Context) {

    private val controller = ReaderModeController(context)

    var state: ReaderModeState = ReaderModeState.DISABLED
        private set

    fun createArticle(
        title: String,
        html: String,
        url: String
    ): ReaderArticle? {
        state = ReaderModeState.LOADING

        return try {
            val article = controller.prepare(title, html, url)

            state = if (ReaderModeValidator.isValid(article)) {
                ReaderModeState.ACTIVE
            } else {
                ReaderModeState.ERROR
            }

            if (state == ReaderModeState.ACTIVE) article else null
        } catch (e: Exception) {
            state = ReaderModeState.ERROR
            null
        }
    }

    fun getController(): ReaderModeController = controller

    fun close() {
        state = ReaderModeState.DISABLED
    }
}
