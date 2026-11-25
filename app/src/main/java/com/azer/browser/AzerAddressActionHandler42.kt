package com.azer.browser

class AzerAddressActionHandler42(
    private val searchManager: AzerSearchManager42 =
        AzerSearchManager42()
) {

    fun handle(input: String): String {
        val text = input.trim()

        if (text.isEmpty()) return ""

        return when (AzerInputDetector42.detect(text)) {
            AzerInputType42.EMPTY -> ""

            AzerInputType42.URL -> {
                if (text.startsWith("http://") ||
                    text.startsWith("https://")) {
                    text
                } else {
                    "https://$text"
                }
            }

            AzerInputType42.SEARCH -> {
                searchManager.search(text)
            }
        }
    }
}
