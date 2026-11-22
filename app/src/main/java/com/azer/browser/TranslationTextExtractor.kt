package com.azer.browser

object TranslationTextExtractor {

    fun clean(text: String): String {
        return text
            .replace(Regex("[\\t ]+"), " ")
            .replace(Regex("\\n{3,}"), "\n\n")
            .trim()
    }

    fun splitBlocks(text: String, maxLength: Int = 3000): List<String> {
        val cleaned = clean(text)
        if (cleaned.length <= maxLength) return listOf(cleaned)

        val result = mutableListOf<String>()
        var current = StringBuilder()

        for (paragraph in cleaned.split("\n")) {
            if (current.length + paragraph.length > maxLength &&
                current.isNotEmpty()
            ) {
                result.add(current.toString())
                current = StringBuilder()
            }

            current.append(paragraph).append("\n")
        }

        if (current.isNotEmpty()) {
            result.add(current.toString())
        }

        return result
    }
}
