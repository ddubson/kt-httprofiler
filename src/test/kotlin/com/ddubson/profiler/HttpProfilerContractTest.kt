package com.ddubson

import com.ddubson.profiler.FakeHttpProfiler
import com.ddubson.profiler.Profiler
import org.hamcrest.CoreMatchers.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertThat
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class HttpProfilerContractTest : Spek({
    describe("an http profiler") {
        val profiler: Profiler = FakeHttpProfiler()

        describe("executing getHeaders") {
            val target = "http://localhost:80"
            val headers: Map<String, String> = profiler.getHeaders(target)

            it("should return application server headers") {
                val expectedHeaders: MutableMap<String, String> = HashMap()
                expectedHeaders.put("Server", "Apache")

                assertThat(expectedHeaders, equalTo(headers))
            }
        }
    }
})