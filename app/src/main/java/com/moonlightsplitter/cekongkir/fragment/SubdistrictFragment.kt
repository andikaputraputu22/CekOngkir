package com.moonlightsplitter.cekongkir.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.R
import com.moonlightsplitter.cekongkir.adapter.SubdistrictAdapter
import com.moonlightsplitter.cekongkir.databinding.FragmentSubdistrictBinding
import com.moonlightsplitter.cekongkir.models.ResultsSubdistrict
import com.moonlightsplitter.cekongkir.tools.Resources
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel
import timber.log.Timber

class SubdistrictFragment : Fragment() {

    private lateinit var binding: FragmentSubdistrictBinding
    private lateinit var subdistrictAdapter: SubdistrictAdapter
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(CityViewModel::class.java) }
    private val cityId by lazy { requireArguments().getString("city_id") }
    private val cityName by lazy { requireArguments().getString("city_name") }
    private val type by lazy { requireActivity().intent.getStringExtra("intent_type") }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubdistrictBinding.inflate(inflater, container, false)
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
        viewModel.titleBar.postValue(getString(R.string.select_subdistrict))
    }

    private fun setupObserver() {
        viewModel.subdistrictResponse.observe(viewLifecycleOwner, Observer { data ->
            when(data) {
                is Resources.Loading -> binding.refreshSubdistrict.isRefreshing = true
                is Resources.Success -> {
                    Timber.d("Subdistrict Response: ${data.data!!.rajaongkir}")
                    binding.refreshSubdistrict.isRefreshing = false
                    subdistrictAdapter.setData(data.data.rajaongkir.results)
                }
                is Resources.Error -> {
                    binding.refreshSubdistrict.isRefreshing = false
                }
            }
        })
    }

    private fun setupListener() {
        binding.refreshSubdistrict.setOnRefreshListener {
            viewModel.fetchSubdistrict(cityId!!)
        }
    }

    private fun setupRecyclerview() {
        subdistrictAdapter = SubdistrictAdapter(arrayListOf(), object : SubdistrictAdapter.OnAdapterListener{
            override fun onClick(result: ResultsSubdistrict) {
                viewModel.savePreferences(
                    type = type!!,
                    id = result.subdistrict_id,
                    name = "$cityName, ${result.subdistrict_name}"
                )
                requireActivity().finish()
            }
        })

        binding.listSubdistrict.adapter = subdistrictAdapter
    }
}