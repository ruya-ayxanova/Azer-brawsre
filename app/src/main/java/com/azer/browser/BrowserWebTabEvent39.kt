package com.azer.browser

sealed class BrowserWebTabEvent39 {

    data class PageStarted(
        val tabId: String,
        val url: String
    ) : BrowserWebTabEvent39()

    data class PageFinished(
        val tabId: String,
        val url: String
    ) : BrowserWebTabEvent39()

    data class ProgressChanged(
        val tabId: String,
        val progress: Int
    ) : BrowserWebTabEvent39()

    data class TitleChanged(
        val tabId: String,
        val title: String
    ) : BrowserWebTabEvent39()

    data class Error(
        val tabId: String,
        val message: String
    ) : BrowserWebTabEvent39()
}
