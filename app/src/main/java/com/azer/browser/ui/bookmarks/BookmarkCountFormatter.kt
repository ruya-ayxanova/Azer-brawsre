package com.azer.browser.ui.bookmarks

object BookmarkCountFormatter {

    fun format(count: Int): String {
        return when (count) {
            0 -> "Henüz yer imi yok"
            1 -> "1 yer imi"
            else -> "$count yer imi"
        }
    }
}
