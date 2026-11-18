package com.azer.browser.ui.bookmarks

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.webkit.WebView

class BookmarkIntegrationPanel(
    context: Context,
    private val store: BookmarkStore,
    private val onOpenBookmarks: () -> Unit
) {

    private val ctx = context

    fun create(
        webView: WebView?,
        onFeedback: (BookmarkToggleResult) -> Unit
    ): LinearLayout {

        val layout = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
        }

        val toggleManager = BookmarkToggleManager(store)

        val url = webView?.url
        val saved = toggleManager.isSaved(url)

        val bookmarkButton = BookmarkButtonFactory.create(
            context = ctx,
            isSaved = saved
        ) {
            val result = toggleManager.toggle(
                webView?.title,
                webView?.url
            )

            BookmarkFeedback.show(ctx, result)
            onFeedback(result)
        }

        val menuButton = BookmarkMenuAction.create(ctx) {
            onOpenBookmarks()
        }

        layout.addView(
            bookmarkButton,
            LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )
        )

        layout.addView(
            menuButton,
            LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                2f
            )
        )

        return layout
    }
}
