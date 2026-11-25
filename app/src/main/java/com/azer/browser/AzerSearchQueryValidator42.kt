package com.azer.browser

object AzerSearchQueryValidator42 {

    fun validate(query: String): Boolean {
        return query.trim().isNotEmpty()
    }

    fun normalize(query: String): String {
        return query.trim().replace(
            Regex("\\s+"),
            " "
        )
    }
}
