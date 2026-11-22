package com.azer.browser

data class BrowserTabCardData(
    val id: String,
    val title: String,
    val url: String,
    val active: Boolean,
    val loading: Boolean
)
