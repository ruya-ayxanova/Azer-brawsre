package com.azer.browser

object ReaderArticleFactory {

    fun create(
        title: String,
        html: String,
        url: String
    ): ReaderArticle {

        val extractedTitle = title.ifBlank {
            ReaderHtmlParser.extractTitle(html)
        }

        val content = ReaderHtmlParser.extractText(html)

        return ReaderArticle(
            title = extractedTitle.ifBlank { "Untitled article" },
            content = content,
            url = url,
            readingMinutes = ReaderTextExtractor.estimateReadingTime(content)
        )
    }
}
