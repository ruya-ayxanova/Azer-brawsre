package com.azer.browser

object AzerAddressBarFormatter42 {

    fun format(text: String): String {
        return text.trim()
    }

    fun display(url: String): String {
        return url.removePrefix("https://")
            .removePrefix("http://")
            .removeSuffix("/")
    }
}
