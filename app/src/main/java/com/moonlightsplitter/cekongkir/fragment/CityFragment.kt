package com.moonlightsplitter.cekongkir.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.moonlightsplitter.cekongkir.R
import com.moonlightsplitter.cekongkir.adapter.CityAdapter
import com.moonlightsplitter.cekongkir.databinding.FragmentCityBinding
import com.moonlightsplitter.cekongkir.models.ResultsCity
import com.moonlightsplitter.cekongkir.tools.Resources
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel
import timber.log.Timber

class CityFragment : Fragment() {

    private lateinit var binding: FragmentCityBinding
    private lateinit var cityAdapter: CityAdapter
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(CityViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        setupObserver()
        setupListener()
        setupRecyclerview()
    }

    private fun setupView() {
        viewModel.titleBar.postValue(getString(R.string.select_city))
    }

    private fun setupObserver() {
        viewModel.cityResponse.observe(viewLifecycleOwner, Observer { data ->
            when(data) {
                is Resources.Loading -> {
                    Timber.d("City Response: Loading")
                    binding.refreshCity.isRefreshing = true
                }
                is Resources.Success -> {
                    binding.refreshCity.isRefreshing = false
                    Timber.d("City Response: ${data.data!!.rajaongkir}")
                    cityAdapter.setData(data.data.rajaongkir.results)
                }
                is Resources.Error -> {
                    binding.refreshCity.isRefreshing = false
                }
            }
        })
    }

    private fun setupListener() {
//        binding.search.setOnClickListener {
//            findNavController().navigate(R.id.action_cityFragment_to_subdistrictFragment)
//        }

        binding.search.doAfterTextChanged {
            cityAdapter.filter.filter(it.toString())
        }

        binding.refreshCity.setOnRefreshListener {
            viewModel.fetchCity()
        }
    }

    private fun setupRecyclerview() {
        cityAdapter = CityAdapter(arrayListOf(), object : CityAdapter.OnAdapterListener{
            override fun onClick(result: ResultsCity) {
                //
            }
        })

        binding.listCity.adapter = cityAdapter
    }
}