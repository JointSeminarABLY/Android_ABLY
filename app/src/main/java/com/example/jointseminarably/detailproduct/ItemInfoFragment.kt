package com.example.jointseminarably.detailproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentItemInfoBinding

class ItemInfoFragment : Fragment() {
    private var _binding: FragmentItemInfoBinding? = null
    val binding get() = _binding ?: error("item info fragment view binding error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCoupon.setOnClickListener{

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}