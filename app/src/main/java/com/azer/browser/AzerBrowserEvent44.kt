sealed class AzerBrowserEvent44 {
    data class PageStarted(val url: String) : AzerBrowserEvent44()
    data class PageFinished(val url: String) : AzerBrowserEvent44()
    data class ProgressChanged(val progress: Int) : AzerBrowserEvent44()
    data class TitleChanged(val title: String) : AzerBrowserEvent44()
    object NavigationFailed : AzerBrowserEvent44()
}
