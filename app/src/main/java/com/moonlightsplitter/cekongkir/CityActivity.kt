package com.moonlightsplitter.cekongkir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.databinding.ActivityCityBinding
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel

class CityActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCityBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this).get(CityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()

        viewModel.titleBar.observe(this, Observer { title ->
            supportActionBar?.title = title
        })
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}