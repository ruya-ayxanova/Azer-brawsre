
package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class HomeSearchBar(
    context: Context,
    hintText: String,
    private val onSearch: (String) -> Unit
) : LinearLayout(context) {

    private val input = EditText(context)

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        setPadding(14, 4, 8, 4)

        background = GradientDrawable().apply {
            setColor(Color.WHITE)
            cornerRadius = 28f
            setStroke(2, Color.LTGRAY)
        }

        input.apply {
            hint = hintText
            textSize = 15f
            singleLine = true
            setTextColor(Color.BLACK)
            setHintTextColor(Color.GRAY)
            background = null
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            layoutParams = LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT,
                1f
            )

            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    submitSearch()
                    true
                } else {
                    false
                }
            }
        }

        val searchButton = TextView(context).apply {
            text = "Ara"
            textSize = 15f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setPadding(18, 12, 18, 12)

            background = GradientDrawable().apply {
                setColor(Color.rgb(27, 94, 65))
                cornerRadius = 24f
            }

            setOnClickListener {
                submitSearch()
            }
        }

        addView(input)
        addView(searchButton)
    }

    private fun submitSearch() {
        val query = input.text.toString().trim()
        if (query.isNotEmpty()) {
            onSearch(query)
        }
    }

    fun setQuery(value: String) {
        input.setText(value)
    }

    fun getQuery(): String {
        return input.text.toString()
    }
}
