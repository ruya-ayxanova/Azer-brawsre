class AzerBrowserControlQueue45 {

    private val queue =
        ArrayDeque<AzerBrowserControlRequest45>()

    fun add(request: AzerBrowserControlRequest45) {
        queue.addLast(request)
    }

    fun next(): AzerBrowserControlRequest45? {
        return if (queue.isEmpty()) null else queue.removeFirst()
    }

    fun size(): Int = queue.size

    fun clear() {
        queue.clear()
    }
}
