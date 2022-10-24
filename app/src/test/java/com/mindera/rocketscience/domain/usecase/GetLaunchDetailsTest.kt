package com.mindera.rocketscience.domain.usecase

import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository
import com.mindera.rocketscience.domain.repository.LaunchDetailsRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetLaunchDetailsTest{

    private lateinit var  mockLaunchDetailsRepository: LaunchDetailsRepository
    private lateinit var  mockGetLaunchDetails: GetLaunchDetails



    @Before
    fun setUp() {
        mockLaunchDetailsRepository = mock()
        mockGetLaunchDetails = GetLaunchDetails(mockLaunchDetailsRepository)
    }

    @Test
    fun `get success on All Launch call`() : Unit = runBlocking {
        val mockSuccess : Resource.Success<List<LaunchDTOItem>> = mock()
        whenever(mockLaunchDetailsRepository.getAllLaunches()).thenReturn(
            mockSuccess
        )
        val response = mockGetLaunchDetails.execute(Unit)
        assertEquals(response.data, mockSuccess)
    }

    @Test
    fun `get failed on All Launch call`() : Unit = runBlocking {
        val mockError : Resource.Error<List<LaunchDTOItem>> = mock()
        whenever(mockLaunchDetailsRepository.getAllLaunches()).thenReturn(
            mockError
        )
        val response = mockGetLaunchDetails.execute(Unit)
        assertEquals(response.data, mockError)
    }
}