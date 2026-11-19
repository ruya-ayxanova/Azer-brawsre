
package com.azer.browser

import android.content.Context

class BrowserTabController(
    context: Context,
    private val listener: BrowserTabListener
) {

    private val session = BrowserTabSession(context)

    val view = BrowserTabStripView(
        context = context,
        onSelect = { id ->
            selectTab(id)
        },
        onClose = { id ->
            closeTab(id)
        },
        onNewTab = {
            createNewTab()
        }
    )

    init {
        refresh()
    }

    fun refresh() {
        view.showTabs(session.getAll())
    }

    fun createNewTab() {
        val tab = session.openNewTab()
        refresh()
        listener.onTabSelected(tab)
    }

    fun selectTab(id: String) {
        val tab = session.select(id) ?: return
        refresh()
        listener.onTabSelected(tab)
    }

    fun closeTab(id: String) {
        val closedTab = session.getAll()
            .find { it.id == id } ?: return

        val activeTab = session.close(id)

        refresh()
        listener.onTabClosed(closedTab)

        activeTab?.let {
            listener.onTabSelected(it)
        }
    }

    fun updateCurrentTab(
        title: String,
        url: String
    ) {
        val current = session.getCurrent() ?: return

        session.update(
            current.id,
            title,
            url
        )

        refresh()
    }

    fun getCurrentTab(): BrowserTab? {
        return session.getCurrent()
    }

    fun getTabs(): List<BrowserTab> {
        return session.getAll()
    }
}
