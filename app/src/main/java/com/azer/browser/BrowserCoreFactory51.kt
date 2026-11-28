package com.azer.browser

object BrowserCoreFactory51 {

    fun create(
        engine: BrowserEngineAdapter51,
        config: BrowserCoreConfig51 =
            BrowserCoreConfig51()
    ): BrowserCoreFacade51 {

        return BrowserCoreFacade51(
            engine = engine,
            config = config
        )
    }
}
