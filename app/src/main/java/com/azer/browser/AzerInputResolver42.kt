package com.azer.browser

class AzerInputResolver42(
    private val searchManager: AzerSearchManager42 =
        AzerSearchManager42()
) {

    fun resolve(input: String): String {
        val text = input.trim()

        when (AzerInputDetector42.detect(text)) {
            AzerInputType42.EMPTY -> return ""

            AzerInputType42.URL -> {
                return if (
                    text.startsWith("https://") ||
                    text.startsWith("http://")
                ) {
                    text
                } else {
                    "https://$text"
                }
            }

            AzerInputType42.SEARCH -> {
                return searchManager.search(text)
            }
        }
    }
}
