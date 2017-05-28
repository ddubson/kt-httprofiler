package com.ddubson.reporter

import com.ddubson.domain.ServerDetails
import com.ddubson.printer.CommandLineAdapter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class HttpReporterTest: Spek({
    describe("http reporter") {
        val commandLineAdapter: CommandLineAdapter = mock()
        val reporter: Reporter = HttpReporter(commandLineAdapter)

        it("prints server report") {
            val serverDetails = ServerDetails("Apache")
            val expectedReport = "Server found: Apache"

            reporter.printReport(serverDetails)

            verify(commandLineAdapter).println(expectedReport)
        }
    }

})