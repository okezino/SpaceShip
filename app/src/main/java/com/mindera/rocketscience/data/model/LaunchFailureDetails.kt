package com.mindera.rocketscience.data.model

data class LaunchFailureDetails(
    val altitude: Int,
    val reason: String,
    val time: Int
)