package com.azer.browser

object TabCloseExecutor38 {

    fun execute(
        request: TabCloseRequest38,
        tabs: MutableList<BrowserTab>
    ): TabCloseResult38 {

        val tab = tabs.find {
            it.id == request.tabId
        }

        if (tab == null) {
            return TabCloseResult38(
                false,
                request.tabId,
                "Sekme bulunamadı"
            )
        }

        tabs.remove(tab)

        if (tab.isActive && tabs.isNotEmpty()) {
            tabs.last().isActive = true
        }

        return TabCloseResult38(
            true,
            request.tabId,
            "Sekme kapatıldı"
        )
    }
}
