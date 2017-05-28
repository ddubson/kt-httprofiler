package com.ddubson.profiler

interface Profiler {
    fun getHeaders(target: String): MutableMap<String, String>
}