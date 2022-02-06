package com.moonlightsplitter.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.api.Client
import com.moonlightsplitter.cekongkir.databinding.ActivityCityBinding
import com.moonlightsplitter.cekongkir.factory.CityViewModelFactory
import com.moonlightsplitter.cekongkir.tools.Resources
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel
import timber.log.Timber

class CityActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCityBinding.inflate(layoutInflater) }
    private lateinit var viewModel: CityViewModel
    private lateinit var viewModelFactory: CityViewModelFactory
    private val api by lazy { Client.instance }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()
        setupObserver()

        setSupportActionBar(binding.toolbar.toolbar)
    }

    private fun setupViewModel() {
        viewModelFactory = CityViewModelFactory(api)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CityViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.titleBar.observe(this, Observer { title ->
            supportActionBar?.title = title
        })
    }
}