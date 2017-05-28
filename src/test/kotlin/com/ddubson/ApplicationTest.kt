package com.ddubson

import com.ddubson.domain.ServerDetails
import com.ddubson.profiler.Profiler
import com.ddubson.reporter.Reporter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito.verify

@RunWith(JUnitPlatform::class)
class ApplicationTest : Spek({
    describe("application") {
        val reporter: Reporter = mock()
        val profiler: Profiler = mock()
        val application: Application = Application(profiler, reporter)

        given("http profiler returns a Server header") {
            it("should report the type of Server found") {
                val baseUrl = "http://www.example.com"
                val endpoint = "/"
                val identifiedServer = "Apache"
                val serverDetails = ServerDetails(identifiedServer)

                whenever(profiler.getServerDetails(baseUrl, endpoint))
                        .thenReturn(serverDetails)

                application.run(baseUrl, endpoint)

                verify(profiler).getServerDetails(baseUrl, endpoint)
                verify(reporter).printReport(serverDetails)
            }
        }
    }
})