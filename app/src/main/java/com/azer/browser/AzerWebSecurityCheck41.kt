package com.azer.browser

object AzerWebSecurityCheck41 {

    fun isHttps(url: String): Boolean {
        return url.startsWith("https://", true)
    }

    fun isHttp(url: String): Boolean {
        return url.startsWith("http://", true)
    }

    fun isWebAddress(url: String): Boolean {
        return isHttps(url) || isHttp(url)
    }

    fun getSecurityLabel(url: String): String {
        return if (isHttps(url)) {
            "Güvenli bağlantı (HTTPS)"
        } else if (isHttp(url)) {
            "Güvenli olmayan HTTP bağlantısı"
        } else {
            "Bilinmeyen bağlantı"
        }
    }
}
