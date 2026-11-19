
package com.azer.browser

data class BrowserTab(
    val id: String,
    var title: String,
    var url: String,
    var isActive: Boolean = false
)
