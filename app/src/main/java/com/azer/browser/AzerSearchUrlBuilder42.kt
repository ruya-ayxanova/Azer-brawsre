package com.azer.browser

import android.net.Uri

object AzerSearchUrlBuilder42 {

    fun build(
        query: String,
        provider: AzerSearchProvider42
    ): String {

        val encoded = Uri.encode(query.trim())

        return when (provider) {
            AzerSearchProvider42.GOOGLE ->
                "https://www.google.com/search?q=$encoded"

            AzerSearchProvider42.BING ->
                "https://www.bing.com/search?q=$encoded"

            AzerSearchProvider42.DUCKDUCKGO ->
                "https://duckduckgo.com/?q=$encoded"

            AzerSearchProvider42.YANDEX ->
                "https://yandex.com/search/?text=$encoded"
        }
    }
}
