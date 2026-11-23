package com.azer.browser

data class BrowserSessionSummary40(
    val sessionId: String,
    val tabCount: Int,
    val activeTabId: String?,
    val isPrivate: Boolean,
    val lastUpdated: Long
) {

    companion object {

        fun from(
            session: BrowserSession40
        ): BrowserSessionSummary40 {

            return BrowserSessionSummary40(
                sessionId = session.sessionId,
                tabCount = session.tabIds.size,
                activeTabId = session.activeTabId,
                isPrivate = session.isPrivate,
                lastUpdated = session.updatedAt
            )
        }
    }
}
