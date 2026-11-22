package com.azer.browser

data class BrowserTabSnapshot(
    val id: String,
    val title: String,
    val url: String,
    val isActive: Boolean,
    val isLoading: Boolean,
    val createdAt: Long,
    val lastAccessedAt: Long
) {

    companion object {

        fun from(tab: BrowserTab): BrowserTabSnapshot {
            return BrowserTabSnapshot(
                id = tab.id,
                title = tab.title,
                url = tab.url,
                isActive = tab.isActive,
                isLoading = tab.isLoading,
                createdAt = tab.createdAt,
                lastAccessedAt = tab.lastAccessedAt
            )
        }
    }
}
