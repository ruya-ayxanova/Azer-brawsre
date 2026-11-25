package com.azer.browser

class AzerAddressBarController42 {

    private var state = AzerAddressBarState42()

    fun getState(): AzerAddressBarState42 {
        return state
    }

    fun setText(text: String) {
        state = state.copy(text = text)
    }

    fun focus() {
        state = state.copy(focused = true)
    }

    fun unfocus() {
        state = state.copy(focused = false)
    }

    fun clear() {
        state = state.copy(text = "")
    }

    fun setLoading(value: Boolean) {
        state = state.copy(isLoading = value)
    }
}
