package com.azer.browser

object ReaderHtmlParser {

    fun extractTitle(html: String): String {
        val title = Regex(
            "<title[^>]*>(.*?)</title>",
            RegexOption.IGNORE_CASE
        ).find(html)?.groupValues?.get(1)

        return decodeEntities(title.orEmpty()).trim()
    }

    fun extractText(html: String): String {
        var text = html

        text = text.replace(
            Regex("<script[\\s\\S]*?</script>", RegexOption.IGNORE_CASE),
            ""
        )

        text = text.replace(
            Regex("<style[\\s\\S]*?</style>", RegexOption.IGNORE_CASE),
            ""
        )

        text = text.replace(
            Regex("<(nav|footer|header|aside|form)[\\s\\S]*?</\\1>",
                RegexOption.IGNORE_CASE),
            ""
        )

        text = text.replace(
            Regex("<br\\s*/?>", RegexOption.IGNORE_CASE),
            "\n"
        )

        text = text.replace(
            Regex("</(p|div|h1|h2|h3|li|article|section)>",
                RegexOption.IGNORE_CASE),
            "\n\n"
        )

        text = text.replace(
            Regex("<[^>]+>"),
            ""
        )

        return ReaderTextExtractor.cleanText(decodeEntities(text))
    }

    private fun decodeEntities(text: String): String {
        return text
            .replace("&nbsp;", " ")
            .replace("&amp;", "&")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
    }
}
