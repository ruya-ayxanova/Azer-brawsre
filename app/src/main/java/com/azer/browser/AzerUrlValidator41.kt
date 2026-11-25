package com.azer.browser

object AzerUrlValidator41 {

    fun isValid(url: String): Boolean {
        return url.isNotBlank() &&
            (url.startsWith("http://") ||
             url.startsWith("https://"))
    }

    fun isSecure(url: String): Boolean {
        return url.startsWith("https://")
    }

    fun isEmpty(url: String): Boolean {
        return url.isBlank()
    }
}
