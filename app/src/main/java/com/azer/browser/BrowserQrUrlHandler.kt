package com.azer.browser

import android.net.Uri

object BrowserQrUrlHandler {

    fun extractUrl(value: String): String? {
        val text = value.trim()

        if (BrowserQrValidator.isValidWebUrl(text)) {
            return text
        }

        val candidate = Regex(
            "(https?://[^\\s]+)",
            RegexOption.IGNORE_CASE
        ).find(text)?.value ?: return null

        val cleaned = candidate.trimEnd('.', ',', ';', ')', ']', '>')
        return cleaned.takeIf {
            BrowserQrValidator.isValidWebUrl(it)
        }
    }

    fun normalize(url: String): String? {
        return try {
            val uri = Uri.parse(url.trim())
            if ((uri.scheme == "http" || uri.scheme == "https") &&
                !uri.host.isNullOrBlank()
            ) {
                uri.toString()
            } else null
        } catch (_: Exception) {
            null
        }
    }
}
