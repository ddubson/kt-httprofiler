package com.ddubson

class FakeHttpProfilerTest : HttpProfilerContractTest() {
    override fun getProfiler(): Profiler {
        return FakeHttpProfiler()
    }
}