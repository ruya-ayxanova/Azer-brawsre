package com.azer.browser

import android.content.Context
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

class ReaderModeToolbar(
    context: Context,
    controller: ReaderModeController,
    onRefresh: () -> Unit
) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER

        val minus = Button(context).apply {
            text = "A−"
            setOnClickListener {
                controller.decreaseFont()
                onRefresh()
            }
        }

        val plus = Button(context).apply {
            text = "A+"
            setOnClickListener {
                controller.increaseFont()
                onRefresh()
            }
        }

        val theme = Button(context).apply {
            text = "Tema"
            setOnClickListener {
                controller.toggleDarkMode()
                onRefresh()
            }
        }

        val font = Button(context).apply {
            text = "Yazı"
            setOnClickListener {
                controller.toggleSerifFont()
                onRefresh()
            }
        }

        addView(minus)
        addView(plus)
        addView(theme)
        addView(font)
    }
}
