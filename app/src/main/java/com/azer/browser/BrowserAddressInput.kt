
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.inputmethod.EditorInfo
import android.widget.EditText

class BrowserAddressInput(
    context: Context,
    private val onSubmit: (String) -> Unit
) : EditText(context) {

    init {
        hint = "Ara veya web adresi yaz"
        textSize = 14f
        singleLine = true
        setTextColor(Color.BLACK)
        setHintTextColor(Color.GRAY)
        setPadding(12, 10, 12, 10)

        background = GradientDrawable().apply {
            setColor(Color.WHITE)
            cornerRadius = 18f
            setStroke(1, Color.LTGRAY)
        }

        imeOptions = EditorInfo.IME_ACTION_GO

        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO ||
                actionId == EditorInfo.IME_ACTION_SEARCH) {
                submit()
                true
            } else {
                false
            }
        }
    }

    private fun submit() {
        val value = text.toString().trim()

        if (value.isNotEmpty()) {
            onSubmit(value)
        }
    }

    fun setAddress(url: String) {
        setText(url)
        setSelection(text.length)
    }

    fun getAddress(): String {
        return text.toString()
    }
}
