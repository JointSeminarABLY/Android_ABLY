package com.example.jointseminarably.detailproduct

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProductInfoAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ItemInfoFragment()
            1 -> ReviewFragment()
            2 -> InquireFragment()
            else -> throw RuntimeException("ERROR PRODUCT FRAGMENT")
        }
    }
}