package com.azer.browser

class AzerWebEventManager41 {

    private val eventList =
        mutableListOf<AzerWebEvent41>()

    fun add(event: AzerWebEvent41) {
        eventList.add(event)
    }

    fun getEvents(): List<AzerWebEvent41> {
        return eventList.toList()
    }

    fun getLastEvent(): AzerWebEvent41? {
        return eventList.lastOrNull()
    }

    fun clear() {
        eventList.clear()
    }
}
