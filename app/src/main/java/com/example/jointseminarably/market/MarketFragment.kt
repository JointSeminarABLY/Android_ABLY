package com.example.jointseminarably.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentMarketBinding

class MarketFragment : Fragment() {
    private var _binding: FragmentMarketBinding? = null
    private val binding get() = _binding ?: throw error("error binding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMarketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMarket.setOnClickListener {
            findNavController().navigate(R.id.action_frameFragment_to_detailProductFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}