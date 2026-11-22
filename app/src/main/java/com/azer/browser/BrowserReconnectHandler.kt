package com.azer.browser

class BrowserReconnectHandler {

    private var wasOffline = false

    fun update(state: BrowserNetworkState): Boolean {
        if (!state.internetAvailable) {
            wasOffline = true
            return false
        }

        if (wasOffline && state.internetAvailable) {
            wasOffline = false
            return true
        }

        return false
    }

    fun reset() {
        wasOffline = false
    }
}
