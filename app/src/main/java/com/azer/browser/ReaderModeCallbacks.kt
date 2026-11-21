package com.azer.browser

interface ReaderModeCallbacks {

    fun onReaderOpened(article: ReaderArticle)

    fun onReaderClosed()

    fun onReaderError(message: String)

    fun onFontChanged(size: Int)
}
