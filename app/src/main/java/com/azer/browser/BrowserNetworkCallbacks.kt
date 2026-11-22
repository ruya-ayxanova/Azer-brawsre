package com.azer.browser

interface BrowserNetworkCallbacks {

    fun onNetworkChanged(state: BrowserNetworkState)

    fun onNetworkConnected(state: BrowserNetworkState)

    fun onNetworkDisconnected()

    fun onInternetAvailable()

    fun onInternetLost()
}
