package com.azer.browser

class TabOperationsController38 {

    private val history =
        TabCommandHistoryManager38()

    fun duplicate(
        tabs: MutableList<BrowserTab>,
        tabId: String
    ): BrowserTab? {

        if (!TabCommandValidator38.canDuplicate(tabs)) {
            return null
        }

        val source = tabs.find {
            it.id == tabId
        } ?: return null

        val newTab = TabDuplicateHelper38.duplicate(source)

        tabs.forEach {
            it.isActive = false
        }

        newTab.isActive = true
        tabs.add(newTab)

        history.add(
            TabMenuItem38.DUPLICATE,
            tabId
        )

        return newTab
    }

    fun close(
        tabs: MutableList<BrowserTab>,
        tabId: String
    ): TabCloseResult38 {

        val request = TabCloseRequest38(tabId)

        val valid = TabCloseValidator38.validate(
            request,
            tabs
        )

        if (!valid) {
            return TabCloseResult38(
                false,
                tabId,
                "Sekme bulunamadı"
            )
        }

        val result = TabCloseExecutor38.execute(
            request,
            tabs
        )

        if (result.success) {
            history.add(
                TabMenuItem38.CLOSE,
                tabId
            )
        }

        return result
    }

    fun closeOthers(
        tabs: MutableList<BrowserTab>,
        selectedId: String
    ): List<BrowserTab> {

        val result = TabCloseOthersHelper38.keepOnly(
            tabs,
            selectedId
        )

        history.add(
            TabMenuItem38.CLOSE_OTHERS,
            selectedId
        )

        return result
    }

    fun getHistory(): List<TabCommandHistory38> {
        return history.getAll()
    }
}
