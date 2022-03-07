package com.moonlightsplitter.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.databinding.ActivityCityBinding
import com.moonlightsplitter.cekongkir.factory.CityViewModelFactory
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class CityActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val viewModelFactory: CityViewModelFactory by instance()
    private val binding by lazy { ActivityCityBinding.inflate(layoutInflater) }
    private lateinit var viewModel: CityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewModel()
        setupObserver()

        setSupportActionBar(binding.toolbar.toolbar)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(CityViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.titleBar.observe(this, Observer { title ->
            supportActionBar?.title = title
        })
    }
}