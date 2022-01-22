package com.moonlightsplitter.cekongkir.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moonlightsplitter.cekongkir.databinding.FragmentCostBinding

class CostFragment : Fragment() {

    private lateinit var binding: FragmentCostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCostBinding.inflate(inflater, container, false)
        return binding.root
    }
}