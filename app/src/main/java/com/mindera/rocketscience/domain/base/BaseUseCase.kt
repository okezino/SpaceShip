package com.mindera.rocketscience.domain.base

abstract class BaseUseCase<in Params, out Response> {
    abstract suspend fun execute(params: Params): Response
}