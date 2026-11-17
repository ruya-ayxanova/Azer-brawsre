
package com.azer.browser.media

import android.content.Context
import android.media.MediaPlayer

class AudioPlayer(
    private val context: Context
) {
    private var player: MediaPlayer? = null

    fun play(url: String) {
        if (!MediaUrlValidator.isValid(url)) return

        release()

        player = MediaPlayer().apply {
            setDataSource(url)
            setOnPreparedListener {
                it.start()
            }
            setOnErrorListener { _, _, _ ->
                release()
                true
            }
            prepareAsync()
        }
    }

    fun pause() {
        if (player?.isPlaying == true) {
            player?.pause()
        }
    }

    fun resume() {
        if (player != null && player?.isPlaying == false) {
            player?.start()
        }
    }

    fun release() {
        player?.release()
        player = null
    }
}
