package com.example.jointseminarably.detailproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentDetailProductBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProductFragment : Fragment() {
    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding ?: throw error("view binding error")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProductImageVeiwPager()
    }

    private fun setProductImageVeiwPager() {
        binding.viewpagerProduct.run {
            adapter = ProductImageAdapter(IMAGE_LIST, this@DetailProductFragment)
            TabLayoutMediator(binding.tablayutDotIndicator, this) { tab,position ->
            }.attach()
        }

    }

    companion object {
        private val IMAGE_LIST = arrayListOf<Int>(R.drawable.photo_pants, R.drawable.photo_pants, R.drawable.photo_pants, R.drawable.photo_pants)
    }

}