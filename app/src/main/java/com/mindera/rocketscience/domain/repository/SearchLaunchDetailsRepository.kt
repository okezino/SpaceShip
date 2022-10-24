package com.mindera.rocketscience.domain.repository

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem

interface SearchLaunchDetailsRepository {
    suspend fun  getAllLaunchesByYear(year : String) : Resource<List<LaunchDTOItem>>

    suspend fun  getAllLaunchesByLaunchStatus(launch : Boolean) : Resource<List<LaunchDTOItem>>
}