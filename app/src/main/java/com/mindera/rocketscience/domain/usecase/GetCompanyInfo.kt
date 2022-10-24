package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.domain.base.BaseUseCase
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository
import javax.inject.Inject

class GetCompanyInfo @Inject constructor(private val companyInfoRepository: CompanyInfoRepository) : BaseUseCase<
        Unit, GetCompanyInfo.Response>(){

    data class Response(
        val data: Resource<CompanyInfoDTO>
    )

    override suspend fun execute(params: Unit): Response {
        return Response(companyInfoRepository.getCompanyInfo())
    }
}