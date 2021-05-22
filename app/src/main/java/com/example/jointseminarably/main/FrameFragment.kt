package com.example.jointseminarably.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentFrameBinding
import java.lang.RuntimeException


class FrameFragment : Fragment() {
    private var _binding: FragmentFrameBinding? = null
    private val binding get() = _binding ?: throw error("error view binding")
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFrameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewpager()
        changePageIdx()
        selectBottomItem()
    }

    private fun changePageIdx() {
        viewModel.pageIdx.observe(viewLifecycleOwner) { pageIdx ->
            binding.viewpager.currentItem = pageIdx
            configureBottomNavigation(pageIdx)
        }
    }

    private fun initViewpager() {
        binding.viewpager.run {
            offscreenPageLimit = 4
            adapter = ViewPagerAdapter(this@FrameFragment)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewModel.changePageIdx(position)
                }
            })
        }
    }

    private fun selectBottomItem(){
        binding.bottomnavigation.run {
            setOnNavigationItemSelectedListener {
                viewModel.changePageIdx(
                    when (it.itemId) {
                        R.id.homeFragment -> 0
                        R.id.styleFragment -> 1
                        R.id.marketFragment -> 2
                        R.id.saveListFragment -> 3
                        R.id.myPageFragment -> 4
                        else -> throw RuntimeException("botttom select error")
                    }
                )
                true
            }
        }
    }

    private fun configureBottomNavigation(pageIdx: Int) {
        binding.bottomnavigation.run {
            menu.getItem(pageIdx).isChecked = true
            itemIconTintList = null
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}