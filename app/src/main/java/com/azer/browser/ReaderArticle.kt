package com.azer.browser

data class ReaderArticle(
    val title: String,
    val content: String,
    val url: String,
    val author: String = "",
    val readingMinutes: Int = 1
)
