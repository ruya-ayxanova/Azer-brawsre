package com.azer.browser

object BrowserWebTabStateCleaner39 {

    fun clean(
        state: BrowserWebTabState39
    ) {
        state.url = ""
        state.title = "Yeni sekme"
        state.progress = 0
        state.isLoading = false
        state.canGoBack = false
        state.canGoForward = false
    }
}
