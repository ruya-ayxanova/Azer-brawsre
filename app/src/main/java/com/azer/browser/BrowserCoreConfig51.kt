package com.azer.browser

data class BrowserCoreConfig51(
    val enableJavaScript: Boolean = true,
    val enableDomStorage: Boolean = true,
    val enableCookies: Boolean = true,
    val enableIncognito: Boolean = false,
    val defaultUserAgent: String = "",
    val homepage: String = "https://www.google.com"
)
