package com.azer.browser

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText

object AzerAddressEditTextFactory43 {

    fun create(context: Context): EditText {
        return EditText(context).apply {
            hint = "Adres veya arama yaz"
            singleLine = true
            textSize = 16f
            setTextColor(Color.BLACK)
            setHintTextColor(Color.GRAY)
            setPadding(16, 0, 16, 0)

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }
}
