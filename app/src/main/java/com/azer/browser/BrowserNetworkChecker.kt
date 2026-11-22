package com.azer.browser

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class BrowserNetworkChecker(context: Context) {

    private val appContext = context.applicationContext

    fun isConnected(): Boolean {
        return getNetworkState().connected
    }

    fun isInternetAvailable(): Boolean {
        return getNetworkState().internetAvailable
    }

    fun getNetworkState(): BrowserNetworkState {
        val manager = appContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = manager.activeNetwork ?: return
                BrowserNetworkState()

            val capabilities = manager.getNetworkCapabilities(network)
                ?: return BrowserNetworkState()

            val connected = capabilities.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_INTERNET
            )

            val validated = capabilities.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_VALIDATED
            )

            val type = when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->
                    BrowserNetworkType.WIFI

                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->
                    BrowserNetworkType.MOBILE

                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ->
                    BrowserNetworkType.ETHERNET

                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) ->
                    BrowserNetworkType.VPN

                connected -> BrowserNetworkType.OTHER

                else -> BrowserNetworkType.NONE
            }

            return BrowserNetworkState(
                connected = connected,
                internetAvailable = validated,
                networkType = type,
                metered = manager.isActiveNetworkMetered
            )
        }

        @Suppress("DEPRECATION")
        val info = manager.activeNetworkInfo

        val connected = info?.isConnected == true

        return BrowserNetworkState(
            connected = connected,
            internetAvailable = connected,
            networkType = when {
                !connected -> BrowserNetworkType.NONE
                info?.type == ConnectivityManager.TYPE_WIFI ->
                    BrowserNetworkType.WIFI
                info?.type == ConnectivityManager.TYPE_MOBILE ->
                    BrowserNetworkType.MOBILE
                else -> BrowserNetworkType.OTHER
            },
            metered = manager.isActiveNetworkMetered
        )
    }
}
