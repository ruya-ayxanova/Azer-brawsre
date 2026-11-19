
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class HomeScreenView(
    context: Context,
    private val settings: HomeScreenSettings,
    private val onSearch: (String) -> Unit,
    private val onOpen: (String) -> Unit,
    private val onClearRecent: () -> Unit
) : ScrollView(context) {

    private val content = LinearLayout(context)
    private val shortcutContainer = LinearLayout(context)
    private val recentContainer = LinearLayout(context)
    private val shortcutSection = LinearLayout(context)
    private val recentSection = LinearLayout(context)

    private val shortcutAdapter = HomeShortcutAdapter(context)
    private val pageAdapter = HomePageAdapter(context)

    init {
        setBackgroundColor(Color.rgb(241, 245, 242))
        isFillViewport = true

        content.orientation = LinearLayout.VERTICAL
        content.setPadding(18, 35, 18, 24)

        val logo = TextView(context).apply {
            text = "AZER BROWSER"
            textSize = 27f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.rgb(27, 94, 65))
            gravity = Gravity.CENTER
            setPadding(0, 10, 0, 25)
        }

        val searchBar = HomeSearchBar(
            context,
            settings.searchHint,
            onSearch
        )

        val searchParams = LinearLayout.LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        ).apply {
            bottomMargin = 30
        }

        content.addView(logo)
        content.addView(searchBar, searchParams)

        buildShortcutSection(context)
        buildRecentSection(context)

        content.addView(shortcutSection)
        content.addView(recentSection)

        addView(content)
    }

    private fun buildShortcutSection(context: Context) {
        shortcutSection.orientation = LinearLayout.VERTICAL

        val heading = TextView(context).apply {
            text = "Hızlı erişim"
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.DKGRAY)
            setPadding(0, 0, 0, 12)
        }

        shortcutContainer.orientation = LinearLayout.HORIZONTAL
        shortcutContainer.gravity = Gravity.CENTER_VERTICAL

        shortcutSection.addView(heading)
        shortcutSection.addView(shortcutContainer)
    }

    private fun buildRecentSection(context: Context) {
        recentSection.orientation = LinearLayout.VERTICAL
        recentSection.setPadding(0, 28, 0, 0)

        val headingRow = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }

        val heading = TextView(context).apply {
            text = "Son ziyaret edilenler"
            textSize = 18f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.DKGRAY)
            layoutParams = LinearLayout.LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT,
                1f
            )
        }

        val clearButton = Button(context).apply {
            text = "Temizle"
            textSize = 11f
            setOnClickListener {
                onClearRecent()
            }
        }

        headingRow.addView(heading)
        headingRow.addView(clearButton)

        recentContainer.orientation = LinearLayout.VERTICAL

        recentSection.addView(headingRow)
        recentSection.addView(recentContainer)
    }

    fun showShortcuts(items: List<HomeShortcut>) {
        shortcutAdapter.render(
            shortcutContainer,
            items,
            onOpen
        )
        shortcutSection.visibility =
            if (settings.showShortcuts) VISIBLE else GONE
    }

    fun showRecentPages(items: List<HomePageItem>) {
        pageAdapter.render(
            recentContainer,
            items,
            onOpen
        )

        recentSection.visibility =
            if (settings.showRecentPages) VISIBLE else GONE
    }
}
