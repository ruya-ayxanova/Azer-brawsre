package com.azer.browser

class BrowserSessionEventManager40 {

    private val events =
        mutableListOf<String>()

    fun record(event: String) {
        if (event.isNotBlank()) {
            events.add(event)
        }
    }

    fun getEvents(): List<String> {
        return events.toList()
    }

    fun getLastEvent(): String? {
        return events.lastOrNull()
    }

    fun clearEvents() {
        events.clear()
    }
}
