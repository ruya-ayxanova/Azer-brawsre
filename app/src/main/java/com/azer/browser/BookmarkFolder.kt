
package com.azer.browser

data class BookmarkFolder(
    val id: String,
    var name: String,
    val createdAt: Long = System.currentTimeMillis()
)
