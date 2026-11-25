package com.azer.browser

object AzerUrlFormatter41 {

    fun format(input: String): String {
        val text = input.trim()

        if (text.isEmpty()) return ""

        if (text.startsWith("http://") ||
            text.startsWith("https://")) {
            return text
        }

        if (text.contains(" ") ||
            !text.contains(".")) {
            return "https://www.google.com/search?q=" +
                text.replace(" ", "+")
        }

        return "https://$text"
    }
}
