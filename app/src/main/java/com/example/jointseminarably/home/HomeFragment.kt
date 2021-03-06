package com.example.jointseminarably.home

import android.app.ActionBar
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentHomeBinding
import com.example.jointseminarably.home.adapter.FashionCategoryAdapter
import com.example.jointseminarably.home.adapter.RankingAdapter
import com.example.jointseminarably.home.adapter.RecommendAdapter
import com.example.jointseminarably.home.adapter.SpecialCategoryAdapter
import com.example.jointseminarably.home.data.FashionCategoryItem
import com.example.jointseminarably.home.data.RankingItem
import com.example.jointseminarably.home.data.RecommendItem
import com.example.jointseminarably.home.data.SpecialCategoryItem

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("not initialized")
    private var check = false

    private val specialCategoryItemList: MutableList<SpecialCategoryItem> = mutableListOf()
    private val fashionCategoryItemList: MutableList<FashionCategoryItem> = mutableListOf()
    private val recommendItemList: MutableList<RecommendItem> = mutableListOf()
    private val rankingItemList: MutableList<RankingItem> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setSpecialCategoryData()
        setFashionCategoryData()
        setRecommendData()
        setRankingData()
        resizeRecyclerview()

        binding.rvSpecialCategory.run{
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = SpecialCategoryAdapter(requireActivity(), requireContext(), specialCategoryItemList)
        }
        binding.rvFashionCategory.run {
            layoutManager = GridLayoutManager(requireContext(), 3)
            fashionCategoryItemList.addAll(FASHION_CATEGORY_LIST.subList(0,9))
            adapter = FashionCategoryAdapter( fashionCategoryItemList)
        }
        binding.rvRecommendProduct.run {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = RecommendAdapter(requireActivity(), requireContext(), recommendItemList){
                findNavController().navigate(R.id.action_frameFragment_to_detailProductFragment)
            }

        }
        binding.rvRanking.run {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = RankingAdapter(requireActivity(), requireContext(), rankingItemList)
        }

        return binding.root
    }

    private fun resizeRecyclerview() {
        binding.imgvDown.setOnClickListener {
            if (check) {
                check = false
                Log.e("false" , check.toString())
                binding.rvFashionCategory.apply {
                    fashionCategoryItemList.clear()
                    fashionCategoryItemList.addAll(FASHION_CATEGORY_LIST.subList(0, 9))
                    adapter = FashionCategoryAdapter( fashionCategoryItemList)
                    (adapter as FashionCategoryAdapter).notifyDataSetChanged()
                }

            } else {
                check = true
                Log.e("true" , check.toString())
                binding.rvFashionCategory.apply {
                    fashionCategoryItemList.clear()
                    fashionCategoryItemList.addAll(FASHION_CATEGORY_LIST)
                    adapter = FashionCategoryAdapter(fashionCategoryItemList)
                    (adapter as FashionCategoryAdapter).notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setSpecialCategoryData(){
        specialCategoryItemList.add(SpecialCategoryItem("?????????"))
        specialCategoryItemList.add(SpecialCategoryItem("????????????"))
        specialCategoryItemList.add(SpecialCategoryItem("?????????"))
    }

    private fun setFashionCategoryData(){
        binding.imgvDown.setOnClickListener{
            fashionCategoryItemList.apply {
                add(FashionCategoryItem("??????"))
                add(FashionCategoryItem("?????????"))
                add(FashionCategoryItem("?????????/??????"))
                add(FashionCategoryItem("??????"))
                add(FashionCategoryItem("?????????"))
                add(FashionCategoryItem("????????????"))
                add(FashionCategoryItem("??????"))
                add(FashionCategoryItem("??????"))
            }
        }

    }

    private fun setRecommendData(){
        recommendItemList.add(RecommendItem(R.drawable.rectangle_6,false,true,"10%","36,000","????????????","????????? ?????????-denim.ts", 10,100))
        recommendItemList.add(RecommendItem(R.drawable.picture_2,false,true,"15%","16,000","?????????","?????? ?????? ??????????????????", 49,91))
        recommendItemList.add(RecommendItem(R.drawable.picture_3,false,false,"0%","13,900","SONA","????????????????????????(TR)", 52,96))
        recommendItemList.add(RecommendItem(R.drawable.picture_4,false,true,"24%","14,500","??????","?????? ???????????? ?????? ?????? ???????????????(OP)", 37,98))
        recommendItemList.add(RecommendItem(R.drawable.picture_5,false,false,"0%","8,900","dear.my","?????? ????????? ???????????? ?????????(T)", 12,78))
        recommendItemList.add(RecommendItem(R.drawable.picture_6,false,true,"27%","13,900","?????????","????????? ????????? ?????? ?????? ??????(NB)", 45,96))
        recommendItemList.add(RecommendItem(R.drawable.picture_7,false,false,"0%","21,600","??????","?????? ????????? ?????? ??? ?????? ?????? ?????????(SK)", 62,88))
        recommendItemList.add(RecommendItem(R.drawable.picture_8,false,false,"0%","14,500","?????????","????????? ?????? 9?????? ?????? ???(T)", 28,100))
        recommendItemList.add(RecommendItem(R.drawable.picture_9,false,false,"0%","16,200","MONO","????????? ?????? ?????? ?????? ?????? ????????? ?????? ?????????", 23,86))
        recommendItemList.add(RecommendItem(R.drawable.picture_10,false,true,"15%","13,200","???????????? ??????","?????? ????????? ?????? ?????? ?????????(OP)", 210,78))
    }

    private fun setRankingData(){
        rankingItemList.add(RankingItem(R.drawable.ranking_1, false, false, "0%", "13,900", "??????", "????????? ??????????????? ??????"))
        rankingItemList.add(RankingItem(R.drawable.ranking_2, false, true, "31%", "21,500", "?????????", "?????? ????????? ?????? ?????????"))
        rankingItemList.add(RankingItem(R.drawable.ranking_3, false, false, "0%", "19,400", "??????", "????????? ?????? ????????? ??????"))
        rankingItemList.add(RankingItem(R.drawable.ranking_4, false, true, "24%", "18,900", "????????????", "????????? ????????????"))
    }

    companion object {
        private val FASHION_CATEGORY_LIST = listOf<FashionCategoryItem>(
            FashionCategoryItem("??????"),
            FashionCategoryItem("?????????"),
            FashionCategoryItem("?????????/??????"),
            FashionCategoryItem("??????"),
            FashionCategoryItem("?????????"),
            FashionCategoryItem("????????????"),
            FashionCategoryItem("??????"),
            FashionCategoryItem("????????????"),
            FashionCategoryItem("?????????"),
            FashionCategoryItem("?????????"),
            FashionCategoryItem("??????/??????"),
            FashionCategoryItem("?????????"),
            FashionCategoryItem("????????????"),
            FashionCategoryItem("????????????")
            )
    }
}