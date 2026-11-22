package com.azer.browser

object TabCloseOthersHelper38 {

    fun keepOnly(
        tabs: MutableList<BrowserTab>,
        selectedId: String
    ): List<BrowserTab> {

        val selected = tabs.find {
            it.id == selectedId
        } ?: return emptyList()

        tabs.clear()

        selected.isActive = true
        tabs.add(selected)

        return tabs.toList()
    }
}
