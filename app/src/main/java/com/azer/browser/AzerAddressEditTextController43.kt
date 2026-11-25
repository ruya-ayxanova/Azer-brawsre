package com.azer.browser

import android.widget.EditText

class AzerAddressEditTextController43(
    private val editText: EditText
) {
    fun setAddress(address: String) {
        editText.setText(address)
    }

    fun getAddress(): String {
        return editText.text.toString()
    }

    fun clear() {
        editText.setText("")
    }

    fun selectAll() {
        editText.selectAll()
    }
}
