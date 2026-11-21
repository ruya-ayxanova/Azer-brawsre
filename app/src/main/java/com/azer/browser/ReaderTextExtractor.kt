package com.azer.browser

object ReaderTextExtractor {

    fun cleanText(text: String): String {
        return text
            .replace(Regex("[\\t ]+"), " ")
            .replace(Regex("\\n{3,}"), "\n\n")
            .trim()
    }

    fun countWords(text: String): Int {
        return text.trim()
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }
            .size
    }

    fun estimateReadingTime(text: String): Int {
        val words = countWords(text)
        return (words / 200.0).toInt().coerceAtLeast(1)
    }
}
