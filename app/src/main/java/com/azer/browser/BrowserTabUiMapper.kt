package com.azer.browser

object BrowserTabUiMapper {

    fun map(tab: BrowserTab): BrowserTabCardData {
        return BrowserTabCardData(
            id = tab.id,
            title = tab.title.ifBlank {
                "Yeni sekme"
            },
            url = tab.url,
            active = tab.isActive,
            loading = tab.isLoading
        )
    }

    fun mapAll(
        tabs: List<BrowserTab>
    ): List<BrowserTabCardData> {
        return tabs.map { map(it) }
    }
}
