package com.azer.browser

class TabCommandHistoryManager38 {

    private val history =
        mutableListOf<TabCommandHistory38>()

    fun add(
        command: TabMenuItem38,
        tabId: String
    ) {

        history.add(
            TabCommandHistory38(
                command = command,
                tabId = tabId
            )
        )
    }

    fun getAll(): List<TabCommandHistory38> {
        return history.toList()
    }

    fun clear() {
        history.clear()
    }

    fun count(): Int {
        return history.size
    }
}
