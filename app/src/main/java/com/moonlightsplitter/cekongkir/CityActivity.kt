package com.moonlightsplitter.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.api.Client
import com.moonlightsplitter.cekongkir.databinding.ActivityCityBinding
import com.moonlightsplitter.cekongkir.factory.CityViewModelFactory
import com.moonlightsplitter.cekongkir.repository.RajaOngkirRepository
import com.moonlightsplitter.cekongkir.tools.Resources
import com.moonlightsplitter.cekongkir.tools.SharedPreferencesManager
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel
import timber.log.Timber

class CityActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCityBinding.inflate(layoutInflater) }
    private lateinit var viewModel: CityViewModel
    private lateinit var viewModelFactory: CityViewModelFactory
    private lateinit var repository: RajaOngkirRepository
    private val api by lazy { Client.instance }
    private val pref by lazy { SharedPreferencesManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()
        setupObserver()

        setSupportActionBar(binding.toolbar.toolbar)
    }

    private fun setupViewModel() {
        repository = RajaOngkirRepository(api, pref)
        viewModelFactory = CityViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CityViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.titleBar.observe(this, Observer { title ->
            supportActionBar?.title = title
        })
    }
}