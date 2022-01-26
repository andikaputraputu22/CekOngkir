package com.moonlightsplitter.cekongkir.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.R
import com.moonlightsplitter.cekongkir.databinding.FragmentSubdistrictBinding
import com.moonlightsplitter.cekongkir.viewmodel.CityViewModel

class SubdistrictFragment : Fragment() {

    private lateinit var binding: FragmentSubdistrictBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(CityViewModel::class.java) }

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
        viewModel.titleBar.postValue(getString(R.string.select_subdistrict))
    }
}