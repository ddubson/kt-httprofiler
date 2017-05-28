package com.ddubson.reporter

import com.ddubson.domain.ServerDetails
import com.ddubson.printer.CommandLineAdapter

class HttpReporter(cmdLine: CommandLineAdapter) : Reporter {
    val cmdLine = cmdLine

    override fun printReport(serverDetails: ServerDetails) {
        cmdLine.println("Server found: " + serverDetails.serverType)
    }
}