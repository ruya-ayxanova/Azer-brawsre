
package com.azer.browser.media

import android.net.Uri

object MediaDetector {

    private val videoExtensions = listOf(
        ".mp4", ".webm", ".m4v", ".3gp", ".mov"
    )

    private val audioExtensions = listOf(
        ".mp3", ".m4a", ".aac", ".ogg", ".wav", ".flac"
    )

    fun detect(url: String): MediaType {
        if (!MediaUrlValidator.isValid(url)) {
            return MediaType.UNKNOWN
        }

        val path = Uri.parse(url).path
            ?.lowercase() ?: return MediaType.UNKNOWN

        return when {
            videoExtensions.any { path.endsWith(it) } ->
                MediaType.VIDEO

            audioExtensions.any { path.endsWith(it) } ->
                MediaType.AUDIO

            else -> MediaType.UNKNOWN
        }
    }
}
