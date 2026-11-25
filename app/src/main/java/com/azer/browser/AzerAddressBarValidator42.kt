package com.azer.browser

object AzerAddressBarValidator42 {

    fun isEmpty(text: String): Boolean {
        return text.trim().isEmpty()
    }

    fun isValidInput(text: String): Boolean {
        return text.trim().isNotEmpty()
    }

    fun clean(text: String): String {
        return text.trim()
    }
}
