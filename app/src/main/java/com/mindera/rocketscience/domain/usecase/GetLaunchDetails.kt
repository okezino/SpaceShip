package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.domain.base.BaseUseCase
import com.mindera.rocketscience.domain.repository.LaunchDetailsRepository
import javax.inject.Inject

class GetLaunchDetails @Inject constructor(val launchDetailsRepository: LaunchDetailsRepository) : BaseUseCase<
        Unit, GetLaunchDetails.Response>(){

    data class Response(
        val data: Resource<List<LaunchDTOItem>>
    )

    override suspend fun execute(params: Unit): Response {
       return Response(launchDetailsRepository.getAllLaunches())
    }


}