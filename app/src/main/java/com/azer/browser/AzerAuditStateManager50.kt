class AzerAuditStateManager50 {

    private var state = AzerAuditState50.IDLE

    fun setState(newState: AzerAuditState50) {
        state = newState
    }

    fun getState(): AzerAuditState50 {
        return state
    }

    fun isRunning(): Boolean {
        return state == AzerAuditState50.RUNNING
    }

    fun isCompleted(): Boolean {
        return state == AzerAuditState50.COMPLETED
    }
}
