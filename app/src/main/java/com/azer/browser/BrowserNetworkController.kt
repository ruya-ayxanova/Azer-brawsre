package com.azer.browser

import android.content.Context

class BrowserNetworkController(context: Context) {

    private val checker = BrowserNetworkChecker(context)
    private val monitor = BrowserNetworkMonitor(context)
    private val settings = BrowserNetworkSettingsManager(context)
    private val eventDetector = BrowserNetworkEventDetector()
    private val reconnectHandler = BrowserReconnectHandler()

    fun getCurrentState(): BrowserNetworkState {
        return checker.getNetworkState()
    }

    fun isOnline(): Boolean {
        return checker.isInternetAvailable()
    }

    fun getSettings(): BrowserNetworkSettings {
        return settings.getSettings()
    }

    fun updateSettings(value: BrowserNetworkSettings) {
        settings.update(value)
    }

    fun startMonitoring(
        onChanged: (BrowserNetworkState) -> Unit
    ) {
        if (!settings.getSettings().monitorConnection) return

        monitor.start { state ->
            eventDetector.detect(state)
            reconnectHandler.update(state)
            onChanged(state)
        }
    }

    fun stopMonitoring() {
        monitor.stop()
    }

    fun getDetectedEvents(
        state: BrowserNetworkState
    ): List<BrowserNetworkEvent> {
        return eventDetector.detect(state)
    }

    fun shouldReloadAfterReconnect(
        state: BrowserNetworkState
    ): Boolean {
        val reconnected = reconnectHandler.update(state)

        return reconnected &&
                settings.getSettings().autoReloadOnReconnect
    }

    fun isMonitoring(): Boolean {
        return monitor.isMonitoring()
    }
}
