package com.azer.browser

data class BrowserWebTabState39(
    val tabId: String,
    var url: String = "",
    var title: String = "Yeni sekme",
    var progress: Int = 0,
    var isLoading: Boolean = false,
    var canGoBack: Boolean = false,
    var canGoForward: Boolean = false
)
