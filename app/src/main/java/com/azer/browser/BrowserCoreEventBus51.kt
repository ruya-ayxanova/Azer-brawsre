package com.azer.browser

class BrowserCoreEventBus51 {

    private val listeners =
        mutableListOf<(BrowserCoreEvent51) -> Unit>()

    fun subscribe(listener: (BrowserCoreEvent51) -> Unit) {
        if (!listeners.contains(listener)) {
            listeners.add(listener)
        }
    }

    fun unsubscribe(listener: (BrowserCoreEvent51) -> Unit) {
        listeners.remove(listener)
    }

    fun emit(event: BrowserCoreEvent51) {
        listeners.toList().forEach { listener ->
            listener(event)
        }
    }

    fun clear() {
        listeners.clear()
    }

    fun listenerCount(): Int {
        return listeners.size
    }
}
