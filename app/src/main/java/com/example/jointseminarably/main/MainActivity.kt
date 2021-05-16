package com.example.jointseminarably.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.RuntimeException

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initViewpager()
        changePageIdx()
        selectBottomItem()
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
}