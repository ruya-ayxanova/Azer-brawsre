package com.azer.browser

object BrowserNetworkValidator {

    fun isValidState(state: BrowserNetworkState): Boolean {
        if (!state.connected &&
            state.networkType != BrowserNetworkType.NONE
        ) {
            return false
        }

        return true
    }

    fun shouldReload(
        state: BrowserNetworkState,
        autoReloadEnabled: Boolean
    ): Boolean {
        return state.internetAvailable && autoReloadEnabled
    }
}
