package com.azer.browser

import java.net.URI

object SitePermissionHostUtils {

    fun extractHost(url: String): String? {
        return try {
            URI(url).host?.lowercase()
        } catch (_: Exception) {
            null
        }
    }

    fun isValidHost(host: String): Boolean {
        return host.isNotBlank() &&
            !host.contains(" ") &&
            host.length <= 253
    }

    fun normalize(host: String): String {
        return host.trim().lowercase()
    }
}
