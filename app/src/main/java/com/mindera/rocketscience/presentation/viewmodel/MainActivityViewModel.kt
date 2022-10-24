package com.mindera.rocketscience.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindera.rocketscience.common.Resource
import com.mindera.rocketscience.data.model.CompanyInfoDTO
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.domain.usecase.GetCompanyInfo
import com.mindera.rocketscience.domain.usecase.GetLaunchDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getCompanyInfo: GetCompanyInfo,
    private val getLaunchDetails: GetLaunchDetails
) : ViewModel(){

    private var _launchListData = MutableLiveData<Resource<List<LaunchDTOItem>>>()
    val launchListData: LiveData<Resource<List<LaunchDTOItem>>> get() = _launchListData

    private var _companyData = MutableLiveData<Resource<CompanyInfoDTO>>()
    val companyData: LiveData<Resource<CompanyInfoDTO>> get() = _companyData

    fun getLaunchList() {
        _launchListData.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            _launchListData.postValue(getLaunchDetails.execute(Unit).data)
        }
    }

    fun getCompanyData() {
        _companyData.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            _companyData.postValue(getCompanyInfo.execute(Unit).data)
        }
    }

}