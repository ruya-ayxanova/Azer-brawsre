package com.azer.browser

object BrowserSessionFactory40 {

    fun create(
        tabIds: List<String> = emptyList(),
        activeTabId: String? = tabIds.firstOrNull(),
        isPrivate: Boolean = false
    ): BrowserSession40 {

        val now = System.currentTimeMillis()

        return BrowserSession40(
            sessionId = java.util.UUID.randomUUID().toString(),
            createdAt = now,
            updatedAt = now,
            activeTabId = activeTabId,
            tabIds = tabIds.distinct(),
            isPrivate = isPrivate
        )
    }
}
