package com.ddubson

import com.ddubson.printer.CommandLineAdapter
import com.ddubson.printer.NativeCommandLineAdapter
import com.ddubson.profiler.HttpProfiler
import com.ddubson.profiler.Profiler
import com.ddubson.reporter.HttpReporter
import com.ddubson.reporter.Reporter

fun main(args: Array<String>) {
    val cmdLine: CommandLineAdapter = NativeCommandLineAdapter()
    val profiler: Profiler = HttpProfiler()
    val reporter: Reporter = HttpReporter(cmdLine)
    Application(profiler, reporter).run(args[0].orEmpty(), args[1].orEmpty())
}