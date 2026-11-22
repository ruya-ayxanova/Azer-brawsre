package com.azer.browser

object BrowserTabSwitcher {

    fun switchTo(
        tabs: MutableList<BrowserTab>,
        targetId: String
    ): BrowserTab? {

        val target = tabs.find { it.id == targetId }
            ?: return null

        tabs.forEach {
            it.isActive = it.id == targetId
        }

        target.lastAccessedAt = System.currentTimeMillis()

        return target
    }
}
