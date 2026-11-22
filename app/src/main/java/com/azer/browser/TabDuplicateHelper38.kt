package com.azer.browser

object TabDuplicateHelper38 {

    fun duplicate(
        source: BrowserTab
    ): BrowserTab {

        return BrowserTab(
            id = java.util.UUID.randomUUID().toString(),
            title = source.title,
            url = source.url,
            isActive = false,
            isLoading = false,
            createdAt = System.currentTimeMillis(),
            lastAccessedAt = System.currentTimeMillis()
        )
    }
}
