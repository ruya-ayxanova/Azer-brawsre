package com.azer.browser

object BrowserTabValidator {

    fun isValid(tab: BrowserTab): Boolean {
        return tab.id.isNotBlank()
    }

    fun isValidUrl(url: String): Boolean {
        return url.isBlank() ||
            url.startsWith("http://") ||
            url.startsWith("https://")
    }

    fun isValidTitle(title: String): Boolean {
        return title.isNotBlank()
    }
}
