package com.azer.browser

class AzerSearchHistoryManager42 {

    private val history =
        mutableListOf<AzerSearchHistoryItem42>()

    fun add(query: String, url: String) {
        if (query.isBlank()) return

        history.removeAll {
            it.query.equals(query, true)
        }

        history.add(
            0,
            AzerSearchHistoryItem42(
                query = query.trim(),
                url = url
            )
        )
    }

    fun getHistory(): List<AzerSearchHistoryItem42> {
        return history.toList()
    }

    fun clear() {
        history.clear()
    }

    fun remove(query: String) {
        history.removeAll {
            it.query == query
        }
    }
}
