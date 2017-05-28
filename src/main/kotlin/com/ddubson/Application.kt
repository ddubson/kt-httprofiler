package com.ddubson

import com.ddubson.profiler.Profiler
import com.ddubson.reporter.Reporter

class Application(profiler: Profiler, reporter: Reporter) {
    val profiler = profiler
    val reporter = reporter

    fun run(baseUrl: String, endpoint: String): Unit {
        val serverDetails = profiler.getServerDetails(baseUrl, endpoint)
        reporter.printReport(serverDetails)
    }
}