package com.moonlightsplitter.cekongkir.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moonlightsplitter.cekongkir.models.PreferencesModel
import com.moonlightsplitter.cekongkir.repository.RajaOngkirRepository

class CostViewModel(
    val repository: RajaOngkirRepository
) : ViewModel() {
    val preferences: MutableLiveData<List<PreferencesModel>> = MutableLiveData()

    fun getPreferences() {
        preferences.value = repository.getPreferences()
    }
}