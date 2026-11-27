class AzerDownloadTypeDetector49 {

    fun detect(
        fileName: String,
        mimeType: String
    ): AzerDownloadType49 {

        val name = fileName.lowercase()
        val mime = mimeType.lowercase()

        return when {
            mime.startsWith("image/") ->
                AzerDownloadType49.IMAGE

            mime.startsWith("video/") ->
                AzerDownloadType49.VIDEO

            mime.startsWith("audio/") ->
                AzerDownloadType49.AUDIO

            name.endsWith(".apk") ->
                AzerDownloadType49.APK

            name.endsWith(".pdf") ||
                    name.endsWith(".doc") ||
                    name.endsWith(".docx") ||
                    name.endsWith(".txt") ->
                AzerDownloadType49.DOCUMENT

            name.endsWith(".zip") ||
                    name.endsWith(".rar") ||
                    name.endsWith(".7z") ->
                AzerDownloadType49.ARCHIVE

            else -> AzerDownloadType49.OTHER
        }
    }
}
