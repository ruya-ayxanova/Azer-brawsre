package com.azer.browser

object AzerInputDetector42 {

    fun detect(input: String): AzerInputType42 {
        val text = input.trim()

        if (text.isEmpty()) {
            return AzerInputType42.EMPTY
        }

        if (text.startsWith("https://") ||
            text.startsWith("http://")) {
            return AzerInputType42.URL
        }

        val looksLikeDomain =
            text.contains(".") &&
            !text.contains(" ") &&
            text.substringAfterLast(".").length >= 2

        return if (looksLikeDomain) {
            AzerInputType42.URL
        } else {
            AzerInputType42.SEARCH
        }
    }
}
