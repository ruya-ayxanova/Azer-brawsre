package com.azer.browser

import android.content.Context
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

object AzerAddressLayoutFactory43 {

    fun attach(
        toolbar: LinearLayout,
        address: EditText
    ) {
        toolbar.addView(
            address,
            LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            )
        )
    }
}
