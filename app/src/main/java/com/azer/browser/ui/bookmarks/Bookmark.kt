package com.azer.browser.ui.bookmarks

data class Bookmark(
    val id: Long,
    val title: String,
    val url: String,
    val addedAt: Long = System.currentTimeMillis()
)
