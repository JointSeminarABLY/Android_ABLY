package com.example.jointseminarably.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jointseminarably.detailproduct.DetailProductFragment
import com.example.jointseminarably.home.HomeFragment
import com.example.jointseminarably.market.MarketFragment
import com.example.jointseminarably.mypage.MyPageFragment
import com.example.jointseminarably.saveList.SaveListFragment
import com.example.jointseminarably.style.StyleFragment

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> StyleFragment()
            2 -> MarketFragment()
            3 -> SaveListFragment()
            //4 -> MyPageFragment()
            4 -> DetailProductFragment()
            else -> throw RuntimeException("--Error Fragment Position--")
        }
    }
}