package com.ddubson

class FakeHttpProfiler : Profiler {
    override fun getHeaders(target: String): MutableMap<String, String> {
        val headers: MutableMap<String, String> = HashMap()
        headers.put("Server", "Apache")
        return headers
    }

}