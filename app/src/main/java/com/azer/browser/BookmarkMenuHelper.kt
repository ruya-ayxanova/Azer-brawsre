
package com.azer.browser

import android.content.Context
import android.view.Menu
import android.view.View
import android.widget.PopupMenu

object BookmarkMenuHelper {

    fun show(
        context: Context,
        anchor: View,
        bookmark: Bookmark,
        onEdit: (Bookmark) -> Unit,
        onDelete: (Bookmark) -> Unit,
        onMove: (Bookmark) -> Unit
    ) {
        val popup = PopupMenu(context, anchor)

        popup.menu.add(Menu.NONE, 1, 1, "Düzenle")
        popup.menu.add(Menu.NONE, 2, 2, "Klasöre taşı")
        popup.menu.add(Menu.NONE, 3, 3, "Sil")

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                1 -> onEdit(bookmark)
                2 -> onMove(bookmark)
                3 -> onDelete(bookmark)
            }
            true
        }

        popup.show()
    }
}
