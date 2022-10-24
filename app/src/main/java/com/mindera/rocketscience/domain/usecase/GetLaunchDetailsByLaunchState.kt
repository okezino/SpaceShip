package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.domain.base.BaseUseCase
import com.mindera.rocketscience.domain.repository.LaunchDetailsRepository
import com.mindera.rocketscience.domain.repository.SearchLaunchDetailsRepository
import javax.inject.Inject

class GetLaunchDetailsByLaunchState @Inject constructor(private val searchLaunchDetailsRepository: SearchLaunchDetailsRepository) : BaseUseCase<
        Boolean, GetLaunchDetailsByLaunchState.Response>(){

    data class Response(
        val data: Resource<List<LaunchDTOItem>>
    )

    override suspend fun execute(params: Boolean): Response {
        return  return Response(searchLaunchDetailsRepository.getAllLaunchesByLaunchStatus(params))
    }

}