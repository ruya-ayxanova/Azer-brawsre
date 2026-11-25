package com.azer.browser

class AzerSearchManager42(
    private var config: AzerSearchConfig42 =
        AzerSearchConfig42()
) {

    fun search(query: String): String {
        return AzerSearchUrlBuilder42.build(
            query,
            config.provider
        )
    }

    fun setProvider(
        provider: AzerSearchProvider42
    ) {
        config = config.copy(provider = provider)
    }

    fun getProvider(): AzerSearchProvider42 {
        return config.provider
    }

    fun getConfig(): AzerSearchConfig42 {
        return config
    }
}
