
package com.azer.browser

object BrowserUrlFormatter {

    fun display(url: String): String {
        return url
            .removePrefix("https://")
            .removePrefix("http://")
            .removePrefix("www.")
            .substringBefore("#")
    }

    fun normalize(url: String): String {
        val value = url.trim()

        if (value.isEmpty()) return ""

        if (value.startsWith("https://") ||
            value.startsWith("http://")) {
            return value
        }

        return "https://$value"
    }
}
