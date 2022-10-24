package com.mindera.rocketscience.domain.repository

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem

interface LaunchDetailsRepository {
    suspend fun  getAllLaunches() : Resource<List<LaunchDTOItem>>
}