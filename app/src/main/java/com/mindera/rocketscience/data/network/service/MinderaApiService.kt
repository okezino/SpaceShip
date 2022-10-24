package com.mindera.rocketscience.data.network.service

import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.data.model.LaunchDTO
import com.mindera.rocketscience.data.model.LaunchDTOItem
import retrofit2.http.GET
import retrofit2.http.Query

interface MinderaApiService {

    @GET("info")
    suspend fun getCompanyInfo() : CompanyInfoDTO

    @GET("launches")
    suspend fun getAllLaunch() : List<LaunchDTOItem>

    @GET("launches")
    suspend fun getAllLaunchByYear(@Query("launch_year") year : String) : List<LaunchDTOItem>

    @GET("launches")
    suspend fun getAllLaunchByLaunchStatus(@Query("launch_success") launch : Boolean) : List<LaunchDTOItem>


}