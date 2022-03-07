package com.moonlightsplitter.cekongkir.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moonlightsplitter.cekongkir.CityActivity
import com.moonlightsplitter.cekongkir.databinding.FragmentCostBinding
import com.moonlightsplitter.cekongkir.viewmodel.CostViewModel

class CostFragment : Fragment() {

    private lateinit var binding: FragmentCostBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(CostViewModel::class.java) }
    private var originId: String? = ""
    private var destinationId: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getPreferences()
    }

    private fun setupObserver() {
        viewModel.preferences.observe(viewLifecycleOwner, Observer { data ->
            data.forEach {
                when(it.type) {
                    "origin" -> {
                        originId = it.id
                        binding.inputOrigin.setText(it.name)
                    }
                    "destination" -> {
                        destinationId = it.id
                        binding.inputDestination.setText(it.name)
                    }
                }
            }
        })
    }

    private fun setupListener() {
        binding.inputOrigin.setOnClickListener {
            startActivity(Intent(context, CityActivity::class.java).putExtra("intent_type", "origin"))
        }

        binding.inputDestination.setOnClickListener {
            startActivity(Intent(context, CityActivity::class.java).putExtra("intent_type", "destination"))
        }
    }
}