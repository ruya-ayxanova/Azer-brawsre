package com.azer.browser

object ReaderModeHtmlBuilder {

    fun build(
        article: ReaderArticle,
        settings: ReaderModeSettings
    ): String {

        val background = if (settings.darkMode) "#181818" else "#FAF7F0"
        val foreground = if (settings.darkMode) "#E6E6E6" else "#292929"
        val font = if (settings.serifFont) "serif" else "sans-serif"

        val title = escape(article.title)
        val content = escape(article.content)
            .replace("\n\n", "<br><br>")
            .replace("\n", "<br>")

        return """
            <!DOCTYPE html>
            <html>
            <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <style>
            body {
                background: $background;
                color: $foreground;
                font-family: $font;
                font-size: ${settings.fontSize}px;
                line-height: ${settings.lineSpacing};
                padding: 20px;
                margin: 0;
            }
            h1 {
                font-size: 1.6em;
                line-height: 1.3;
                margin-bottom: 20px;
            }
            article {
                white-space: normal;
                overflow-wrap: break-word;
            }
            </style>
            </head>
            <body>
            <h1>$title</h1>
            <article>$content</article>
            </body>
            </html>
        """.trimIndent()
    }

    private fun escape(text: String): String {
        return text
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;")
    }
}
