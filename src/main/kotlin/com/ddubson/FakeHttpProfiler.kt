package com.ddubson

class FakeHttpProfiler: Profiler {
    override fun getHeaders(target: String): MutableMap<String, String> {
        return HashMap()
    }

}