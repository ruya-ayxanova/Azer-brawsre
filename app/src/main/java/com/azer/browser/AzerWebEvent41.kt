package com.azer.browser

sealed class AzerWebEvent41 {

    data class Started(
        val url: String
    ) : AzerWebEvent41()

    data class Finished(
        val url: String
    ) : AzerWebEvent41()

    data class Progress(
        val value: Int
    ) : AzerWebEvent41()

    data class TitleChanged(
        val title: String
    ) : AzerWebEvent41()

    data class Error(
        val message: String
    ) : AzerWebEvent41()
}
