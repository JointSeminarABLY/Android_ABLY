package com.example.jointseminarably.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.ActivityMainBinding
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initViewpager()
        changePageIdx()
    }

    private fun changePageIdx() {
        viewModel.pageIdx.observe(this) { pageIdx ->
            binding.viewpager.currentItem = pageIdx
            configureBottomNavigation(pageIdx)
        }
    }

    private fun initViewpager() {
        binding.viewpager.run {
            offscreenPageLimit = 4
            adapter = ViewPagerAdapter(this@MainActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewModel.changePageIdx(position)
                }
            })
        }
    }

    private fun configureBottomNavigation(pageIdx: Int) {
        binding.bottomnavigation.run {
            menu.getItem(pageIdx).isChecked = true
            itemIconTintList = null

        }
    }
}