package com.azer.browser

import android.content.Context

object BrowserNetworkFactory {

    fun createChecker(context: Context): BrowserNetworkChecker {
        return BrowserNetworkChecker(context)
    }

    fun createMonitor(context: Context): BrowserNetworkMonitor {
        return BrowserNetworkMonitor(context)
    }

    fun createController(context: Context): BrowserNetworkController {
        return BrowserNetworkController(context)
    }

    fun createSettings(context: Context): BrowserNetworkSettingsManager {
        return BrowserNetworkSettingsManager(context)
    }

    fun createStatus(context: Context): BrowserNetworkStatus {
        val state = BrowserNetworkChecker(context).getNetworkState()

        return BrowserNetworkStatus(
            state = state,
            quality = BrowserNetworkQualityChecker.evaluate(state),
            displayName = BrowserNetworkFormatter.typeText(state),
            description = BrowserNetworkFormatter.connectionText(state)
        )
    }
}
