
package com.azer.browser

import java.net.URLEncoder

object BrowserSearchEngine {

    private const val GOOGLE =
        "https://www.google.com/search?q="

    fun createSearchUrl(query: String): String {
        val encoded = URLEncoder.encode(
            query.trim(),
            "UTF-8"
        )

        return GOOGLE + encoded
    }

    fun resolveInput(value: String): String {
        val text = value.trim()

        if (text.isEmpty()) return ""

        if (text.startsWith("https://") ||
            text.startsWith("http://")) {
            return text
        }

        if (BrowserAddressValidator.isWebAddress(text)) {
            return BrowserUrlFormatter.normalize(text)
        }

        return createSearchUrl(text)
    }
}
