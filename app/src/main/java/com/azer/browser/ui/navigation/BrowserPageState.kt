package com.azer.browser.ui.navigation

data class BrowserPageState(
    val url: String = "",
    val title: String = "",
    val progress: Int = 0,
    val loading: Boolean = false,
    val error: String? = null
)
