package com.ddubson.printer

class NativeCommandLineAdapter : CommandLineAdapter {
    override fun println(message: String) {
        kotlin.io.println(message)
    }
}