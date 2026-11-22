package com.azer.browser

object BrowserTabTitleFormatter {

    fun format(title: String): String {

        if (title.isBlank()) {
            return "Yeni sekme"
        }

        return if (
            title.length > BrowserTabUiConstants.MAX_TITLE_LENGTH
        ) {
            title.take(
                BrowserTabUiConstants.MAX_TITLE_LENGTH
            ) + "..."
        } else {
            title
        }
    }
}
