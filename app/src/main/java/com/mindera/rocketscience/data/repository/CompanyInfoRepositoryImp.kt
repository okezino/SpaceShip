package com.mindera.rocketscience.data.repository

import com.mindera.rocketscience.common.NetworkUtil
import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.data.network.service.MinderaApiService
import com.mindera.rocketscience.domain.base.BaseRepositoryService
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository
import java.lang.Exception
import javax.inject.Inject

class CompanyInfoRepositoryImp @Inject constructor(val minderaApiService: MinderaApiService) : BaseRepositoryService(), CompanyInfoRepository {

    override suspend fun getCompanyInfo(): Resource<CompanyInfoDTO> = executeRequest {
     try {
         val response = minderaApiService.getCompanyInfo()
         Resource.Success(response)
     }catch (e : Exception){
         Resource.Error(e.localizedMessage ?: NetworkUtil.NETWORK_ERROR)
     }
    }
}