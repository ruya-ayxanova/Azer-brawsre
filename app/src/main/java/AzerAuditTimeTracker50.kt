class AzerAuditTimeTracker50 {

    private var startTime = 0L
    private var endTime = 0L

    fun start() {
        startTime = System.currentTimeMillis()
        endTime = 0L
    }

    fun finish() {
        endTime = System.currentTimeMillis()
    }

    fun getDuration(): Long {
        if (startTime == 0L) return 0L

        val end = if (endTime == 0L) {
            System.currentTimeMillis()
        } else {
            endTime
        }

        return end - startTime
    }
}
