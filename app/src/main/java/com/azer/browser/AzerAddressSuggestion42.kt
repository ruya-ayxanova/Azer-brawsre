package com.azer.browser

class AzerAddressSuggestion42(
    private val historyManager:
        AzerSearchHistoryManager42
) {

    fun suggest(input: String): List<String> {
        val text = input.trim()

        if (text.isEmpty()) return emptyList()

        return historyManager.getHistory()
            .map { it.query }
            .filter {
                it.contains(text, ignoreCase = true)
            }
            .distinct()
            .take(8)
    }
}
