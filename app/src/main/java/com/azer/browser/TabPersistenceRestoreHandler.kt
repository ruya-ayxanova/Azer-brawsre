package com.azer.browser

class TabPersistenceRestoreHandler(
    private val manager: TabPersistenceManager
) {

    fun restoreOrCreate(): List<BrowserTab> {

        val restored = manager.restoreTabs()

        if (restored.isNotEmpty()) {
            return restored
        }

        return listOf(
            BrowserTabFactory.create()
                .copy(isActive = true)
        )
    }
}
