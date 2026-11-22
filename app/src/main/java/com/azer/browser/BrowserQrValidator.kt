package com.azer.browser

object BrowserQrValidator {

    fun isValidContent(content: String): Boolean {
        return content.isNotBlank() &&
                content.length <= BrowserQrConstants.MAX_CONTENT_LENGTH
    }

    fun isValidWebUrl(content: String): Boolean {
        return try {
            val uri = android.net.Uri.parse(content.trim())
            (uri.scheme == "http" || uri.scheme == "https") &&
                    !uri.host.isNullOrBlank()
        } catch (_: Exception) {
            false
        }
    }

    fun isSafeWebUrl(content: String): Boolean {
        if (!isValidWebUrl(content)) return false

        val uri = android.net.Uri.parse(content.trim())
        return uri.userInfo == null
    }
}
