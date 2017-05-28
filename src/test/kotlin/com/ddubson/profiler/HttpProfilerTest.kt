package com.ddubson.profiler

import com.ddubson.domain.ServerDetails
import org.hamcrest.CoreMatchers.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertThat
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class HttpProfilerTest : Spek({
    describe("an http profiler") {
        val profiler: Profiler = HttpProfiler()

        describe("executing getServerDetails") {
            val baseUrl = "http://www.example.com"
            val endpoint = "/"
            val serverDetails: ServerDetails = profiler.getServerDetails(baseUrl, endpoint)

            it("should return application server headers") {
                val expectedServerDetails = ServerDetails("Unidentified")

                assertThat(expectedServerDetails.serverType, equalTo(serverDetails.serverType))
            }
        }
    }
})