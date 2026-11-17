package com.azer.browser.tabs

data class BrowserTab(
    val id: Int,
    var title: String = "Yeni sekme",
    var url: String = "https://www.google.com",
    var isPrivate: Boolean = false,
    var isActive: Boolean = false
)
