package com.mindera.rocketscience.data.repository

import com.mindera.rocketscience.common.NetworkUtil.NETWORK_ERROR
import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.data.network.service.MinderaApiService
import com.mindera.rocketscience.domain.base.BaseRepositoryService
import com.mindera.rocketscience.domain.repository.LaunchDetailsRepository
import java.lang.Exception
import javax.inject.Inject

class LaunchDetailsRepositoryImp @Inject constructor(private val minderaApiService: MinderaApiService) : BaseRepositoryService(), LaunchDetailsRepository {

    override suspend fun getAllLaunches(): Resource<List<LaunchDTOItem>> = executeRequest {
        try{
            val response = minderaApiService.getAllLaunch()
            Resource.Success(response)
        }catch (e : Exception){
            Resource.Error(e.localizedMessage ?: NETWORK_ERROR)
        }
    }

}