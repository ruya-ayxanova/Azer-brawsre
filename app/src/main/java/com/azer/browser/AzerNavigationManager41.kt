package com.azer.browser

class AzerNavigationManager41 {

    fun prepare(
        input: String
    ): AzerNavigationRequest41? {

        val url = AzerUrlFormatter41.format(input)

        if (url.isBlank()) return null

        return AzerNavigationRequest41(
            url = url,
            fromSearch = url.contains("/search?q=")
        )
    }

    fun validate(
        request: AzerNavigationRequest41
    ): Boolean {
        return request.url.startsWith("https://") ||
            request.url.startsWith("http://")
    }
}
