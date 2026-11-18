package com.azer.browser.ui.bookmarks

class BookmarkToggleManager(
    private val store: BookmarkStore
) {

    fun toggle(title: String?, url: String?): BookmarkToggleResult {
        if (url.isNullOrBlank()) {
            return BookmarkToggleResult.INVALID_URL
        }

        if (!url.startsWith("http://", true) &&
            !url.startsWith("https://", true)
        ) {
            return BookmarkToggleResult.INVALID_URL
        }

        if (store.contains(url)) {
            val bookmark = store.getAll()
                .firstOrNull { it.url.equals(url, true) }

            return if (bookmark != null && store.remove(bookmark.id)) {
                BookmarkToggleResult.REMOVED
            } else {
                BookmarkToggleResult.FAILED
            }
        }

        val resolvedTitle = BookmarkTitleResolver.resolve(title, url)

        return if (store.add(resolvedTitle, url)) {
            BookmarkToggleResult.ADDED
        } else {
            BookmarkToggleResult.ALREADY_EXISTS
        }
    }

    fun isSaved(url: String?): Boolean {
        if (url.isNullOrBlank()) return false
        return store.contains(url)
    }
}
