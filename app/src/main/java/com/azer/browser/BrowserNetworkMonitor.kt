package com.azer.browser

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.net.NetworkCapabilities
import android.os.Build

class BrowserNetworkMonitor(context: Context) {

    private val appContext = context.applicationContext

    private val connectivityManager =
        appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

    private var callback: ConnectivityManager.NetworkCallback? = null

    fun start(onChanged: (BrowserNetworkState) -> Unit) {
        if (callback != null) return

        val networkCallback =
            object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    onChanged(BrowserNetworkChecker(appContext).getNetworkState())
                }

                override fun onLost(network: Network) {
                    onChanged(BrowserNetworkChecker(appContext).getNetworkState())
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    onChanged(BrowserNetworkChecker(appContext).getNetworkState())
                }
            }

        callback = networkCallback

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                connectivityManager.registerDefaultNetworkCallback(
                    networkCallback
                )
            } else {
                val request = NetworkRequest.Builder()
                    .addCapability(
                        NetworkCapabilities.NET_CAPABILITY_INTERNET
                    )
                    .build()

                connectivityManager.registerNetworkCallback(
                    request,
                    networkCallback
                )
            }
        } catch (e: Exception) {
            callback = null
        }
    }

    fun stop() {
        callback?.let {
            try {
                connectivityManager.unregisterNetworkCallback(it)
            } catch (_: Exception) {
            }
        }

        callback = null
    }

    fun isMonitoring(): Boolean {
        return callback != null
    }
}
