package com.mindera.rocketscience.data.repository

import com.mindera.rocketscience.common.NetworkUtil
import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.data.network.service.MinderaApiService
import com.mindera.rocketscience.domain.base.BaseRepositoryService
import com.mindera.rocketscience.domain.repository.SearchLaunchDetails
import java.lang.Exception
import javax.inject.Inject

class SearchLaunchDetailsImp @Inject constructor(private val minderaApiService: MinderaApiService) : BaseRepositoryService(), SearchLaunchDetails{
    override suspend fun getAllLaunchesByYear(year: String): Resource<List<LaunchDTOItem>> = executeRequest {
        try{
            val response = minderaApiService.getAllLaunchByYear(year)
            Resource.Success(response)
        }catch (e : Exception){
            Resource.Error(e.localizedMessage ?: NetworkUtil.NETWORK_ERROR)
        }
    }

    override suspend fun getAllLaunchesByLaunchStatus(launch: Boolean): Resource<List<LaunchDTOItem>>  = executeRequest {
        try{
            val response = minderaApiService.getAllLaunchByLaunchStatus(launch)
            Resource.Success(response)
        }catch (e : Exception){
            Resource.Error(e.localizedMessage ?: NetworkUtil.NETWORK_ERROR)
        }
    }
}