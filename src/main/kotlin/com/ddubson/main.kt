package com.ddubson

import com.ddubson.profiler.FakeHttpProfiler
import com.ddubson.profiler.Profiler
import com.ddubson.reporter.HttpReporter
import com.ddubson.reporter.Reporter

fun main(args: Array<String>) {
    val profiler: Profiler = FakeHttpProfiler()
    val reporter: Reporter = HttpReporter()
    Application(profiler, reporter).run(args[0])
}