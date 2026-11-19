
package com.azer.browser

import android.content.Context

class HomeScreenController(
    context: Context,
    private val onOpenPage: (String) -> Unit
) {

    private val repository = HomePageRepository(context)
    private val settings = HomeScreenSettings(context)

    val view = HomeScreenView(
        context = context,
        settings = settings,
        onSearch = { query ->
            openSearchOrAddress(query)
        },
        onOpen = { url ->
            onOpenPage(url)
        },
        onClearRecent = {
            repository.clearRecentPages()
            refresh()
        }
    )

    init {
        refresh()
    }

    fun refresh() {
        view.showShortcuts(repository.getShortcuts())
        view.showRecentPages(repository.getRecentPages())
    }

    fun addShortcut(title: String, url: String) {
        if (title.isBlank() || url.isBlank()) return

        repository.addShortcut(
            HomeShortcut(title.trim(), url.trim())
        )

        refresh()
    }

    fun removeShortcut(url: String) {
        repository.removeShortcut(url)
        refresh()
    }

    fun recordVisitedPage(title: String, url: String) {
        repository.addRecentPage(title, url)
        refresh()
    }

    fun clearHistoryOnHomePage() {
        repository.clearRecentPages()
        refresh()
    }

    private fun openSearchOrAddress(query: String) {
        val value = query.trim()
        if (value.isEmpty()) return

        val hasSpaces = value.contains(" ")
        val hasScheme = value.startsWith("https://") ||
                value.startsWith("http://")

        val looksLikeAddress = !hasSpaces &&
                (value.contains(".") || hasScheme)

        val destination = when {
            hasScheme -> value
            looksLikeAddress -> "https://$value"
            else -> "https://www.google.com/search?q=" +
                    java.net.URLEncoder.encode(value, "UTF-8")
        }

        onOpenPage(destination)
    }
}
