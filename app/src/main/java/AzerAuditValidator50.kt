class AzerAuditValidator50 {

    fun isValid(
        result: AzerAuditResult50
    ): Boolean {
        return result.totalChecks >= 0 &&
                result.passed >= 0 &&
                result.warnings >= 0 &&
                result.errors >= 0 &&
                result.passed +
                result.warnings +
                result.errors <= result.totalChecks
    }
}
