package com.azer.browser

object BrowserUrlResolver51 {

    fun resolve(input: String): String {
        val value = input.trim()

        if (value.isEmpty()) {
            return ""
        }

        if (value.startsWith("http://") ||
            value.startsWith("https://")) {
            return value
        }

        if (value.contains(" ") ||
            !value.contains(".")) {
            return "https://www.google.com/search?q=" +
                    value.replace(" ", "+")
        }

        return "https://$value"
    }
}
