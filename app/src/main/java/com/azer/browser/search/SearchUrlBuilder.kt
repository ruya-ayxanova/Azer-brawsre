
package com.azer.browser.search

import android.net.Uri

object SearchUrlBuilder {

    private const val GOOGLE =
        "https://www.google.com/search?q="

    fun build(input: String): String {
        val text = input.trim()

        if (text.isEmpty()) {
            return "https://www.google.com"
        }

        if (text.startsWith("https://") ||
            text.startsWith("http://")) {
            return text
        }

        if (text.contains(".") && !text.contains(" ")) {
            return "https://$text"
        }

        return GOOGLE + Uri.encode(text)
    }
}
