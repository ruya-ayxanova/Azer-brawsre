package com.azer.browser

import android.content.Context
import android.view.View
import android.widget.LinearLayout

object BrowserTabUiRenderer {

    fun render(
        context: Context,
        state: BrowserTabUiState
    ): LinearLayout {

        val container =
            BrowserTabListFactory.create(context)

        if (state.tabs.isEmpty()) {
            container.addView(
                BrowserTabEmptyView.create(context)
            )
            return container
        }

        state.tabs.forEach { tab ->

            val card =
                BrowserTabCardFactory.create(
                    context,
                    tab
                )

            card.background =
                BrowserTabCardStyle.background(
                    tab.active
                )

            container.addView(card)
        }

        if (state.showNewTabButton) {
            container.addView(
                BrowserTabNewCard.create(context)
            )
        }

        return container
    }

    fun clear(view: LinearLayout) {
        view.removeAllViews()
    }
}
