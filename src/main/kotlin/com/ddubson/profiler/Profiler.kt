package com.ddubson

interface Profiler {
    fun getHeaders(target: String): MutableMap<String, String>
}