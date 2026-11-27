class AzerBrowserResumeManager47 {

    private var resumeInfo =
        AzerBrowserResumeInfo47()

    fun save(info: AzerBrowserResumeInfo47) {
        resumeInfo = info
    }

    fun getSavedInfo(): AzerBrowserResumeInfo47 {
        return resumeInfo
    }

    fun clear() {
        resumeInfo = AzerBrowserResumeInfo47()
    }

    fun hasSavedUrl(): Boolean {
        return resumeInfo.lastUrl.isNotBlank()
    }
}
