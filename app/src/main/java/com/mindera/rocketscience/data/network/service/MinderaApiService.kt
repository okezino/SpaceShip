package com.mindera.rocketscience.data.network.service

import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.data.model.LaunchDTO
import com.mindera.rocketscience.data.model.LaunchDTOItem
import retrofit2.http.GET

interface MinderaApiService {

    @GET("info")
    suspend fun getCompanyInfo() : CompanyInfoDTO

    @GET("launches")
    suspend fun getAllLaunch() : LaunchDTO
}