
package com.azer.browser.tabs

data class TabState(
    val tabId: Int,
    val scrollPosition: Int = 0,
    val url: String = "",
    val title: String = ""
)
