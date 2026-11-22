package com.azer.browser

object TabCloseAllHelper38 {

    fun closeAll(
        tabs: MutableList<BrowserTab>
    ): Int {

        val count = tabs.size

        tabs.clear()

        return count
    }
}
