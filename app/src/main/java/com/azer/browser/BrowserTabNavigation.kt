package com.azer.browser

object BrowserTabNavigation {

    fun next(
        tabs: List<BrowserTab>,
        currentId: String
    ): BrowserTab? {

        if (tabs.isEmpty()) return null

        val index = tabs.indexOfFirst {
            it.id == currentId
        }

        if (index < 0) return tabs.first()

        val nextIndex = (index + 1) % tabs.size

        return tabs[nextIndex]
    }

    fun previous(
        tabs: List<BrowserTab>,
        currentId: String
    ): BrowserTab? {

        if (tabs.isEmpty()) return null

        val index = tabs.indexOfFirst {
            it.id == currentId
        }

        if (index < 0) return tabs.last()

        val previousIndex =
            if (index == 0) tabs.lastIndex
            else index - 1

        return tabs[previousIndex]
    }
}
