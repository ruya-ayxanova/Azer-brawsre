package com.azer.browser

class BrowserTabRepository {

    private val tabs = mutableListOf<BrowserTab>()

    fun getAll(): List<BrowserTab> {
        return tabs.toList()
    }

    fun getById(id: String): BrowserTab? {
        return tabs.find { it.id == id }
    }

    fun add(tab: BrowserTab): Boolean {
        if (!BrowserTabValidator.isValid(tab)) return false
        if (tabs.size >= BrowserTabLimits.MAX_TABS) return false
        if (getById(tab.id) != null) return false

        tabs.add(tab)
        return true
    }

    fun remove(id: String): BrowserTab? {
        val tab = getById(id) ?: return null
        tabs.remove(tab)
        return tab
    }

    fun clear() {
        tabs.clear()
    }

    fun count(): Int {
        return tabs.size
    }

    fun isEmpty(): Boolean {
        return tabs.isEmpty()
    }
}
