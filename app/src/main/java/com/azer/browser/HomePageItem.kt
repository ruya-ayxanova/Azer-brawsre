
package com.azer.browser

data class HomePageItem(
    val title: String,
    val url: String,
    val visitedAt: Long = System.currentTimeMillis()
)
