package com.ddubson

import com.ddubson.profiler.Profiler
import com.ddubson.reporter.Reporter

class Application(profiler: Profiler, reporter: Reporter) {
    val profiler = profiler
    val reporter = reporter

    fun run(target: String): Unit {
        val headers = profiler.getHeaders(target)
        reporter.printReport(headers.getOrDefault("Server", ""))
    }
}