package com.azer.browser

sealed class BrowserCoreEvent51 {

    data class NavigationStarted(
        val url: String
    ) : BrowserCoreEvent51()

    data class NavigationFinished(
        val url: String
    ) : BrowserCoreEvent51()

    data class NavigationFailed(
        val url: String,
        val message: String
    ) : BrowserCoreEvent51()

    data class ProgressChanged(
        val progress: Int
    ) : BrowserCoreEvent51()

    object LoadingStopped : BrowserCoreEvent51()

    object HistoryChanged : BrowserCoreEvent51()
}
