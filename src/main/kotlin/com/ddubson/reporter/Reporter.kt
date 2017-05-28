package com.ddubson.reporter

import com.ddubson.domain.ServerDetails

interface Reporter {
    fun printReport(serverDetails: ServerDetails): Unit
}