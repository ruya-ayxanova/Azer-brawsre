package com.azer.browser.ui.bookmarks

class BookmarkRefreshController(
    private val controller: BookmarkScreenController
) {

    fun refresh(): List<Bookmark> {
        return controller.getBookmarks()
    }

    fun getCount(): Int {
        return controller.getBookmarks().size
    }
}
