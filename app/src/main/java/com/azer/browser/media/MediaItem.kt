
package com.azer.browser.media

data class MediaItem(
    val url: String,
    val title: String,
    val type: MediaType,
    val size: Long = -1L
)
