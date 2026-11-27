class AzerWebViewMemoryMonitor48 {

    fun getUsedMemoryMb(): Long {
        val runtime = Runtime.getRuntime()

        val usedBytes =
            runtime.totalMemory() - runtime.freeMemory()

        return usedBytes / (1024L * 1024L)
    }

    fun getMaxMemoryMb(): Long {
        return Runtime.getRuntime().maxMemory() /
                (1024L * 1024L)
    }

    fun getFreeMemoryMb(): Long {
        return Runtime.getRuntime().freeMemory() /
                (1024L * 1024L)
    }
}
