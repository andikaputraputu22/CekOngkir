package com.moonlightsplitter.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.moonlightsplitter.cekongkir.adapter.HomeTabAdapter
import com.moonlightsplitter.cekongkir.databinding.ActivityMainBinding
import com.moonlightsplitter.cekongkir.factory.CostViewModelFactory
import com.moonlightsplitter.cekongkir.viewmodel.CostViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModelFactory: CostViewModelFactory by instance()
    private lateinit var viewModel: CostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()
        setupTab()
        setupViewModel()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.title = getString(R.string.cek_ongkir_resi)
    }

    private fun setupTab() {
        val titles = arrayOf(getString(R.string.cek_ongkir), getString(R.string.cek_resi))
        val tabAdapter = HomeTabAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(CostViewModel::class.java)
    }
}