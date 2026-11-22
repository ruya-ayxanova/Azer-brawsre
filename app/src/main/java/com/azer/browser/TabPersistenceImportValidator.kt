package com.azer.browser

object TabPersistenceImportValidator {

    fun validate(
        snapshot: TabPersistenceSnapshot?
    ): Boolean {

        if (snapshot == null) return false

        if (snapshot.tabs.isEmpty()) return false

        if (snapshot.tabs.size >
            TabPersistenceConstants.MAX_SAVED_TABS
        ) {
            return false
        }

        val ids = snapshot.tabs.map { it.id }

        if (ids.distinct().size != ids.size) {
            return false
        }

        return snapshot.tabs.all {
            TabPersistenceValidator.isValid(it) &&
                    TabPersistenceValidator.isValidUrl(it.url)
        }
    }
}
