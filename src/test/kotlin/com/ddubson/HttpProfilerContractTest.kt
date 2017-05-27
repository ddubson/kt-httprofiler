package com.ddubson

import org.hamcrest.CoreMatchers.equalTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals

abstract class HttpProfilerContractTest : Spek({
    describe("an http profiler") {
        val profiler: Profiler = getProfiler()

        describe("executing getHeaders") {
            val target = "http://localhost:80"
            val headers: Map<String, String> = profiler.getHeaders(target)

            it("should return application server headers") {
                val expectedHeaders: MutableMap<String, String> = HashMap()
                expectedHeaders.put("Server", "Apache")

                assertEquals(headers, equalTo(expectedHeaders))
            }
        }
    }
}) {
    abstract fun getProfiler(): Profiler
}