package com.mindera.rocketscience.domain.repository

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.CompanyInfoDTO

interface CompanyInfoRepository {
    suspend fun getCompanyInfo() : Resource<CompanyInfoDTO>
}