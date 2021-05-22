package com.example.jointseminarably.detailproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentProductImageBinding

class ProductImageFragment(private val image : Int) : Fragment() {
    private var _binding: FragmentProductImageBinding? = null
    private val binding get() = _binding ?: throw error("--FragmentProductDetail ViewBinding Error--")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadProductImage()
    }

    private fun loadProductImage() {
        binding.ivProduct.load(image)
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}