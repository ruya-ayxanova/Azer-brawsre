
package com.azer.browser

data class Bookmark(
    val id: String,
    var title: String,
    var url: String,
    var folderId: String,
    val createdAt: Long = System.currentTimeMillis()
)
