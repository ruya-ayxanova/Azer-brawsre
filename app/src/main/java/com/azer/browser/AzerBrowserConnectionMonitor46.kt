class AzerBrowserConnectionMonitor46 {

    fun evaluate(
        connected: Boolean
    ): AzerBrowserConnectionState46 {
        return if (connected) {
            AzerBrowserConnectionState46.CONNECTED
        } else {
            AzerBrowserConnectionState46.DISCONNECTED
        }
    }
}
