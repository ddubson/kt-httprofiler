package com.ddubson.profiler

import com.ddubson.domain.ServerDetails

interface Profiler {
    fun getServerDetails(baseUrl: String, endpoint: String): ServerDetails
}