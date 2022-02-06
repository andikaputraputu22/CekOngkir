package com.moonlightsplitter.cekongkir.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.api.Api
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel

class CityViewModelFactory(
    private val api: Api
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CityViewModel(api) as T
    }
}