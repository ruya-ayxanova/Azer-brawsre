package com.azer.browser

object BrowserTabUrlFormatter {

    fun format(url: String): String {

        if (url.isBlank()) {
            return "Adres girilmedi"
        }

        return if (
            url.length > BrowserTabUiConstants.MAX_URL_LENGTH
        ) {
            url.take(
                BrowserTabUiConstants.MAX_URL_LENGTH
            ) + "..."
        } else {
            url
        }
    }

    fun shortUrl(url: String): String {

        return try {
            val uri = java.net.URI(url)
            uri.host ?: url
        } catch (e: Exception) {
            url
        }
    }
}
