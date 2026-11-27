class AzerBrowserOperationReporter46 {

    fun createReport(
        results: List<AzerBrowserOperationResult46>
    ): String {

        val successful = results.count { it.success }
        val failed = results.count { !it.success }

        return buildString {
            appendLine("Azer Browser işlem raporu")
            appendLine("Toplam: ${results.size}")
            appendLine("Başarılı: $successful")
            appendLine("Başarısız: $failed")
        }
    }
}
