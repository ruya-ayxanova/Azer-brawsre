package com.azer.browser

class BrowserSecurityPolicy51 {

    fun allowNavigation(url: String): Boolean {
        if (url.isBlank()) return false

        return url.startsWith("https://") ||
                url.startsWith("http://")
    }

    fun isSecureConnection(url: String): Boolean {
        return url.startsWith("https://")
    }

    fun requiresWarning(url: String): Boolean {
        return url.startsWith("http://")
    }

    fun shouldBlock(url: String): Boolean {
        return !allowNavigation(url)
    }
}
