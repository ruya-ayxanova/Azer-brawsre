package com.azer.browser

object BrowserUrlValidator51 {

    fun isValid(url: String): Boolean {
        if (url.isBlank()) return false

        return url.startsWith("https://") ||
                url.startsWith("http://")
    }

    fun isSecure(url: String): Boolean {
        return url.startsWith("https://")
    }

    fun isHttp(url: String): Boolean {
        return url.startsWith("http://")
    }
}
