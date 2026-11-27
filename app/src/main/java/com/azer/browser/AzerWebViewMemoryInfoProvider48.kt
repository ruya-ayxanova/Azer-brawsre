class AzerWebViewMemoryInfoProvider48 {

    private val monitor =
        AzerWebViewMemoryMonitor48()

    fun getInfo(): AzerWebViewMemoryInfo48 {
        return AzerWebViewMemoryInfo48(
            usedMemoryMb = monitor.getUsedMemoryMb(),
            freeMemoryMb = monitor.getFreeMemoryMb(),
            maxMemoryMb = monitor.getMaxMemoryMb()
        )
    }
}
