package com.mindera.rocketscience.domain.usecase


import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository
import org.junit.Before
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class GetCompanyInfoTest {

    private lateinit var  mockCompanyInfoRepository: CompanyInfoRepository
    private lateinit var  mockGetCompanyInfo: GetCompanyInfo



    @Before
    fun setUp() {
        mockCompanyInfoRepository = mock()
        mockGetCompanyInfo = GetCompanyInfo(mockCompanyInfoRepository)
    }

    @Test
    fun `get success on Company call`() : Unit = runBlocking {
        val mockSuccess : Resource.Success<CompanyInfoDTO> = mock()
        whenever(mockCompanyInfoRepository.getCompanyInfo()).thenReturn(
            mockSuccess
        )
        val response = mockGetCompanyInfo.execute(Unit)
        assertEquals(response.data, mockSuccess)
    }

    @Test
    fun `get failed on Company call`() : Unit = runBlocking {
        val mockError : Resource.Error<CompanyInfoDTO> = mock()
        whenever(mockCompanyInfoRepository.getCompanyInfo()).thenReturn(
            mockError
        )
        val response = mockGetCompanyInfo.execute(Unit)
        assertEquals(response.data, mockError)
    }
}