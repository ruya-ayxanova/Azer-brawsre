
package com.azer.browser

import android.content.Context

class BookmarkSettings(context: Context) {

    private val prefs = context.getSharedPreferences(
        "azer_bookmark_settings",
        Context.MODE_PRIVATE
    )

    var sortOrder: BookmarkSortOrder
        get() {
            val name = prefs.getString(
                "sort_order",
                BookmarkSortOrder.NEWEST.name
            )

            return runCatching {
                BookmarkSortOrder.valueOf(
                    name ?: BookmarkSortOrder.NEWEST.name
                )
            }.getOrDefault(BookmarkSortOrder.NEWEST)
        }
        set(value) {
            prefs.edit()
                .putString("sort_order", value.name)
                .apply()
        }

    var showFolders: Boolean
        get() = prefs.getBoolean("show_folders", true)
        set(value) {
            prefs.edit()
                .putBoolean("show_folders", value)
                .apply()
        }
}
