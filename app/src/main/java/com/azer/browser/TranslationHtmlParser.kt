package com.azer.browser

object TranslationHtmlParser {

    fun extractTitle(html: String): String {
        return Regex(
            "<title[^>]*>(.*?)</title>",
            RegexOption.IGNORE_CASE
        ).find(html)?.groupValues?.get(1)?.let(::decode)
            ?.trim().orEmpty()
    }

    fun extractText(html: String): String {
        var text = html

        val removeTags = listOf(
            "script", "style", "noscript", "svg"
        )

        for (tag in removeTags) {
            text = text.replace(
                Regex(
                    "<$tag[^>]*>[\\s\\S]*?</$tag>",
                    RegexOption.IGNORE_CASE
                ),
                ""
            )
        }

        text = text.replace(
            Regex("<br\\s*/?>", RegexOption.IGNORE_CASE),
            "\n"
        )

        text = text.replace(
            Regex("</(p|div|h1|h2|h3|li|article)>",
                RegexOption.IGNORE_CASE),
            "\n"
        )

        text = text.replace(Regex("<[^>]+>"), "")

        return TranslationTextExtractor.clean(decode(text))
    }

    private fun decode(text: String): String {
        return text
            .replace("&nbsp;", " ")
            .replace("&amp;", "&")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
    }
}
