
package com.azer.browser

import android.content.Context
import java.util.UUID

class BrowserTabManager(context: Context) {

    private val store = BrowserTabStore(context)
    private val tabs = mutableListOf<BrowserTab>()

    init {
        tabs.addAll(store.load())

        if (tabs.isEmpty()) {
            addTab("Yeni sekme", "about:blank")
        } else {
            val activeIndex = tabs.indexOfFirst { it.isActive }
            val selectedIndex = if (activeIndex >= 0) activeIndex else 0

            tabs.forEachIndexed { index, tab ->
                tab.isActive = index == selectedIndex
            }

            save()
        }
    }

    @Synchronized
    fun getTabs(): List<BrowserTab> {
        return tabs.map { it.copy() }
    }

    @Synchronized
    fun getActiveTab(): BrowserTab? {
        return tabs.firstOrNull { it.isActive }?.copy()
    }

    @Synchronized
    fun addTab(
        title: String = "Yeni sekme",
        url: String = "about:blank"
    ): BrowserTab {
        val tab = BrowserTab(
            id = UUID.randomUUID().toString(),
            title = title,
            url = url,
            isActive = true
        )

        tabs.forEach { it.isActive = false }
        tabs.add(tab)
        save()

        return tab.copy()
    }

    @Synchronized
    fun selectTab(id: String): BrowserTab? {
        val selected = tabs.find { it.id == id } ?: return null

        tabs.forEach {
            it.isActive = it.id == id
        }

        save()
        return selected.copy()
    }

    @Synchronized
    fun closeTab(id: String): BrowserTab? {
        val index = tabs.indexOfFirst { it.id == id }

        if (index == -1) return getActiveTab()

        val wasActive = tabs[index].isActive
        tabs.removeAt(index)

        if (tabs.isEmpty()) {
            return addTab()
        }

        if (wasActive) {
            val newIndex = index.coerceAtMost(tabs.lastIndex)

            tabs.forEachIndexed { i, tab ->
                tab.isActive = i == newIndex
            }
        }

        save()
        return getActiveTab()
    }

    @Synchronized
    fun updateTab(
        id: String,
        title: String,
        url: String
    ) {
        val tab = tabs.find { it.id == id } ?: return

        tab.title = title.ifBlank { "Yeni sekme" }
        tab.url = url

        save()
    }

    @Synchronized
    fun count(): Int = tabs.size

    private fun save() {
        store.save(tabs)
    }
}
