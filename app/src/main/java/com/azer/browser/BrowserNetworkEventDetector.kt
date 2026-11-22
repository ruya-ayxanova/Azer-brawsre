package com.azer.browser

class BrowserNetworkEventDetector {

    private var previousState: BrowserNetworkState? = null

    fun detect(
        current: BrowserNetworkState
    ): List<BrowserNetworkEvent> {

        val events = mutableListOf<BrowserNetworkEvent>()
        val previous = previousState

        if (previous == null) {
            if (current.connected) {
                events.add(BrowserNetworkEvent.CONNECTED)
            }

            if (current.internetAvailable) {
                events.add(BrowserNetworkEvent.INTERNET_AVAILABLE)
            }

            previousState = current
            return events
        }

        if (!previous.connected && current.connected) {
            events.add(BrowserNetworkEvent.CONNECTED)
        }

        if (previous.connected && !current.connected) {
            events.add(BrowserNetworkEvent.DISCONNECTED)
        }

        if (!previous.internetAvailable && current.internetAvailable) {
            events.add(BrowserNetworkEvent.INTERNET_AVAILABLE)
        }

        if (previous.internetAvailable && !current.internetAvailable) {
            events.add(BrowserNetworkEvent.INTERNET_LOST)
        }

        if (previous.networkType != current.networkType) {
            events.add(BrowserNetworkEvent.TYPE_CHANGED)
        }

        previousState = current
        return events
    }

    fun reset() {
        previousState = null
    }
}
