package com.azer.browser

object BrowserSecurityChecker {

    fun isHttps(url: String): Boolean {
        return try {
            java.net.URI(url)
                .scheme
                ?.equals("https", ignoreCase = true) == true
        } catch (_: Exception) {
            false
        }
    }

    fun isHttp(url: String): Boolean {
        return try {
            java.net.URI(url)
                .scheme
                ?.equals("http", ignoreCase = true) == true
        } catch (_: Exception) {
            false
        }
    }

    fun securityLabel(url: String): String {
        return when {
            isHttps(url) -> "Güvenli bağlantı"
            isHttp(url) -> "Güvenli olmayan bağlantı"
            else -> "Bilinmeyen bağlantı"
        }
    }
}
