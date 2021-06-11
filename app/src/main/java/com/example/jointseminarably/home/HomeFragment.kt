package com.example.jointseminarably.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchProductList()
        setRecommendData()
        setRankingData()
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
        specialCategoryItemList.add(SpecialCategoryItem("이벤트"))
        specialCategoryItemList.add(SpecialCategoryItem("코스메틱"))
        specialCategoryItemList.add(SpecialCategoryItem("홈데코"))
    }

    private fun setFashionCategoryData(){
        binding.imgvDown.setOnClickListener{
            fashionCategoryItemList.apply {
                add(FashionCategoryItem("상의"))
                add(FashionCategoryItem("아우터"))
                add(FashionCategoryItem("원피스/세트"))
                add(FashionCategoryItem("팬츠"))
                add(FashionCategoryItem("스커트"))
                add(FashionCategoryItem("트레이닝"))
                add(FashionCategoryItem("가방"))
                add(FashionCategoryItem("신발"))
            }
        }

    }

    private fun setRecommendData(){
        recommendItemList.add(RecommendItem(R.drawable.rectangle_6,false,true,"10%","36,000","모코블링","블루밍 티셔츠-denim.ts", 10,100))
        recommendItemList.add(RecommendItem(R.drawable.picture_2,false,true,"15%","16,000","예냥냥","빌즈 썸머 벤딩코튼팬츠", 49,91))
        recommendItemList.add(RecommendItem(R.drawable.picture_3,false,false,"0%","13,900","SONA","턴온트레이닝세트(TR)", 52,96))
        recommendItemList.add(RecommendItem(R.drawable.picture_4,false,true,"24%","14,500","소현","소피 배색카라 리본 체크 반팔원피스(OP)", 37,98))
        recommendItemList.add(RecommendItem(R.drawable.picture_5,false,false,"0%","8,900","dear.my","슬림 베이직 스퀘어넥 반팔티(T)", 12,78))
        recommendItemList.add(RecommendItem(R.drawable.picture_6,false,true,"27%","13,900","다현샵","시그널 박시핏 린넨 체크 남방(NB)", 45,96))
        recommendItemList.add(RecommendItem(R.drawable.picture_7,false,false,"0%","21,600","소현","포엠 데일리 여름 청 데님 미니 스커트(SK)", 62,88))
        recommendItemList.add(RecommendItem(R.drawable.picture_8,false,false,"0%","14,500","다현샵","파스텔 반팔 9컬러 니트 티(T)", 28,100))
        recommendItemList.add(RecommendItem(R.drawable.picture_9,false,false,"0%","16,200","MONO","알케이 자수 패치 카라 버튼 베이직 미니 원피스", 23,86))
        recommendItemList.add(RecommendItem(R.drawable.picture_10,false,true,"15%","13,200","아카이브 윤경","미니 슬림핏 버튼 니트 원피스(OP)", 210,78))
    }

    private fun setRankingData(){
        rankingItemList.add(RankingItem(R.drawable.ranking_1, false, false, "0%", "13,900", "소현", "반팔티 멜빵원피스 세트"))
        rankingItemList.add(RankingItem(R.drawable.ranking_2, false, true, "31%", "21,500", "다현샵", "잔꽃 플라워 미니 원피스"))
        rankingItemList.add(RankingItem(R.drawable.ranking_3, false, false, "0%", "19,400", "비비", "피크닉 나시 스커트 린넨"))
        rankingItemList.add(RankingItem(R.drawable.ranking_4, false, true, "24%", "18,900", "베베옷장", "카리나 린넨원피"))
    }

    companion object {
        private val FASHION_CATEGORY_LIST = listOf<FashionCategoryItem>(
            FashionCategoryItem("상의"),
            FashionCategoryItem("아우터"),
            FashionCategoryItem("원피스/세트"),
            FashionCategoryItem("팬츠"),
            FashionCategoryItem("스커트"),
            FashionCategoryItem("트레이닝"),
            FashionCategoryItem("가방"),
            FashionCategoryItem("패션소품"),
            FashionCategoryItem("주얼리"),
            FashionCategoryItem("디지털"),
            FashionCategoryItem("완구/팬시"),
            FashionCategoryItem("홈웨어"),
            FashionCategoryItem("언더웨어"),
            FashionCategoryItem("비치웨어")
            )
    }
}