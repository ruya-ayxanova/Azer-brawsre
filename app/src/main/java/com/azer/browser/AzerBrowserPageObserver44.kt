class AzerBrowserPageObserver44 {

    fun onPageStarted(url: String): AzerBrowserEvent44 {
        return AzerBrowserEvent44.PageStarted(url)
    }

    fun onPageFinished(url: String): AzerBrowserEvent44 {
        return AzerBrowserEvent44.PageFinished(url)
    }

    fun onProgressChanged(progress: Int): AzerBrowserEvent44 {
        return AzerBrowserEvent44.ProgressChanged(
            progress.coerceIn(0, 100)
        )
    }

    fun onTitleChanged(title: String): AzerBrowserEvent44 {
        return AzerBrowserEvent44.TitleChanged(title)
    }
}
