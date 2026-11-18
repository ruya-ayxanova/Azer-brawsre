package com.azer.browser.ui.navigation

object BrowserTitleFormatter {

    fun format(title: String?, url: String?): String {
        val cleanTitle = title?.trim().orEmpty()

        if (cleanTitle.isNotBlank()) {
            return cleanTitle.take(100)
        }

        val host = try {
            android.net.Uri.parse(url).host
        } catch (e: Exception) {
            null
        }

        return host ?: "Yeni Sekme"
    }
}
