class AzerAuditReportFormatter50 {

    fun format(
        result: AzerAuditResult50
    ): String {

        return """
            Azer Browser Audit Report

            Status: ${result.status}
            Total checks: ${result.totalChecks}
            Passed: ${result.passed}
            Warnings: ${result.warnings}
            Errors: ${result.errors}
        """.trimIndent()
    }
}
