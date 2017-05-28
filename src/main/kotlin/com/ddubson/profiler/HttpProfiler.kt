package com.ddubson.profiler

import com.ddubson.domain.ServerDetails
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager

class HttpProfiler : Profiler {
    override fun getServerDetails(baseUrl: String, endpoint: String): ServerDetails {
        FuelManager.instance.basePath = "http://$baseUrl"
        val (request, response, result) = Fuel.head(endpoint).responseString()
        val serverHeader: List<String> = response.httpResponseHeaders.get("Server").orEmpty()

        if (!serverHeader.isEmpty()) {
            return ServerDetails(serverHeader[0])
        } else {
            return ServerDetails("Unidentified")
        }
    }

}