package com.moonlightsplitter.cekongkir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonlightsplitter.cekongkir.api.Api
import com.moonlightsplitter.cekongkir.models.CityModel
import com.moonlightsplitter.cekongkir.models.ProvinceModel
import com.moonlightsplitter.cekongkir.models.SubdistrictModel
import com.moonlightsplitter.cekongkir.tools.Resources
import kotlinx.coroutines.launch

class CityViewModel(
    private val api: Api
) : ViewModel() {
    val titleBar: MutableLiveData<String> = MutableLiveData("")
    val cityResponse: MutableLiveData<Resources<CityModel>> = MutableLiveData()
    val subdistrictResponse: MutableLiveData<Resources<SubdistrictModel>> = MutableLiveData()

    init {
        fetchCity()
    }

    fun fetchCity() = viewModelScope.launch {
        cityResponse.value = Resources.Loading()
        try {
            cityResponse.value = Resources.Success(api.getCity().body()!!)
        } catch (e: Exception) {
            cityResponse.value = Resources.Error(e.message.toString())
        }
    }

    fun fetchSubdistrict(id: String) = viewModelScope.launch {
        subdistrictResponse.value = Resources.Loading()
        try {
            subdistrictResponse.value = Resources.Success(api.getSubdistrict(id).body()!!)
        } catch (e: Exception) {
            subdistrictResponse.value = Resources.Error(e.message.toString())
        }
    }
}