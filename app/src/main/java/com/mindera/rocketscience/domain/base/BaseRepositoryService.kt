package com.mindera.rocketscience.domain.base

open class BaseRepositoryService {
    suspend fun <T> executeRequest(request: suspend () -> T): T {
        return request()
    }
}