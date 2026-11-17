
package com.azer.browser.media

import android.widget.VideoView
import android.widget.MediaController
import android.content.Context

object VideoPlayerHelper {

    fun play(
        context: Context,
        videoView: VideoView,
        url: String
    ) {
        if (!MediaUrlValidator.isValid(url)) return

        val controller = MediaController(context)

        controller.setAnchorView(videoView)

        videoView.setMediaController(controller)
        videoView.setVideoPath(url)

        videoView.setOnPreparedListener {
            videoView.start()
        }
    }
}
