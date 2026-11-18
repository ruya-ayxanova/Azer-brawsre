package com.azer.browser.ui.tabs

data class BrowserTabEntry(
    val id: Int,
    var title: String,
    var url: String,
    var isActive: Boolean = false
)
