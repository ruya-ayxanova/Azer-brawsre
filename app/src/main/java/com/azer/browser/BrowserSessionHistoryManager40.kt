package com.azer.browser

class BrowserSessionHistoryManager40 {

    private val history =
        mutableListOf<BrowserSessionHistory40>()

    fun add(
        sessionId: String,
        action: BrowserSessionAction40,
        description: String
    ) {
        history.add(
            BrowserSessionHistory40(
                sessionId = sessionId,
                action = action,
                timestamp = System.currentTimeMillis(),
                description = description
            )
        )
    }

    fun getHistory(): List<BrowserSessionHistory40> {
        return history.toList()
    }

    fun clear() {
        history.clear()
    }

    fun getLast(): BrowserSessionHistory40? {
        return history.lastOrNull()
    }
}
