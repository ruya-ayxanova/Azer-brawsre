
package com.azer.browser.tabs

class TabManager {

    private val tabs = mutableListOf<BrowserTab>()
    private var nextId = 1

    fun createTab(privateMode: Boolean = false): BrowserTab {
        val tab = BrowserTab(
            id = nextId++,
            isPrivate = privateMode,
            isActive = true
        )

        tabs.forEach { it.isActive = false }
        tabs.add(tab)
        return tab
    }

    fun getTabs(): List<BrowserTab> = tabs.toList()

    fun getActiveTab(): BrowserTab? =
        tabs.find { it.isActive }

    fun selectTab(id: Int): Boolean {
        if (tabs.none { it.id == id }) return false

        tabs.forEach { it.isActive = it.id == id }
        return true
    }

    fun closeTab(id: Int) {
        tabs.removeAll { it.id == id }

        if (tabs.none { it.isActive } && tabs.isNotEmpty()) {
            tabs.last().isActive = true
        }
    }

    fun count(): Int = tabs.size
}
