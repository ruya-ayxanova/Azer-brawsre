class AzerAuditLogger50 {

    private val logs = mutableListOf<String>()

    fun add(message: String) {
        logs.add(message)
    }

    fun getLogs(): List<String> {
        return logs.toList()
    }

    fun clear() {
        logs.clear()
    }
}
