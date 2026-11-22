package com.azer.browser

object TabMenuBuilder38 {

    fun build(tabId: String): TabMenuState38 {
        return TabMenuState38(
            tabId = tabId,
            visible = true,
            items = listOf(
                TabMenuItem38.OPEN_NEW,
                TabMenuItem38.DUPLICATE,
                TabMenuItem38.RELOAD,
                TabMenuItem38.COPY_URL,
                TabMenuItem38.CLOSE,
                TabMenuItem38.CLOSE_OTHERS,
                TabMenuItem38.CLOSE_ALL
            )
        )
    }
}
