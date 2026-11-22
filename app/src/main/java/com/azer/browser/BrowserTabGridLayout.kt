package com.azer.browser

import android.content.Context
import android.widget.GridLayout

object BrowserTabGridLayout {

    fun create(
        context: Context,
        columns: Int = 2
    ): GridLayout {

        val grid = GridLayout(context)

        grid.columnCount = columns.coerceAtLeast(1)
        grid.rowCount = 0

        grid.tag = "browser_tab_grid"

        return grid
    }
}
