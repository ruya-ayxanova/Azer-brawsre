package com.azer.browser

data class BrowserPageSnapshot51(
    val url: String = "",
    val title: String = "",
    val progress: Int = 0,
    val state: BrowserCoreState51 =
        BrowserCoreState51.IDLE,
    val canGoBack: Boolean = false,
    val canGoForward: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
)
