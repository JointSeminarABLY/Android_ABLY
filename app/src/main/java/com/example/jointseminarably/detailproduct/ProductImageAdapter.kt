package com.example.jointseminarably.detailproduct

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jointseminarably.databinding.FragmentProductImageBinding

class ProductImageAdapter(private val imageList: List<Int>, fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = imageList.size

    override fun createFragment(position: Int): Fragment {
        return ProductImageFragment(imageList[position])
    }
}