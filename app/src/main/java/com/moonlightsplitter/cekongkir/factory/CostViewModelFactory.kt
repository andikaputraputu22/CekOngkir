package com.moonlightsplitter.cekongkir.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.repository.RajaOngkirRepository
import com.moonlightsplitter.cekongkir.viewmodel.CostViewModel

class CostViewModelFactory(
    private val repository: RajaOngkirRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CostViewModel(repository) as T
    }
}