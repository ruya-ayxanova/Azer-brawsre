package com.azer.browser

object ReaderModeUtils {

    fun getReadingTime(text: String): String {
        val minutes = ReaderTextExtractor.estimateReadingTime(text)
        return "$minutes dakika okuma"
    }

    fun formatWordCount(text: String): String {
        val count = ReaderTextExtractor.countWords(text)
        return "$count kelime"
    }

    fun isSupportedUrl(url: String): Boolean {
        return url.startsWith("http://") ||
                url.startsWith("https://")
    }

    fun normalizeUrl(url: String): String {
        return url.trim()
    }
}
