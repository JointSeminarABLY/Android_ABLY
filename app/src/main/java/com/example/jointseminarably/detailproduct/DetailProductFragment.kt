package com.example.jointseminarably.detailproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.FragmentDetailProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProductFragment : Fragment() {

    private lateinit var binding: FragmentDetailProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_product, container, false)
        val itemList = mutableListOf<ProductData>()
        itemList.add(ProductData("", "29,900", "내츄럴린넨펜츠(2color)", R.drawable.rectangle_32_1))
        itemList.add(ProductData("", "35,000", "핀턱롱와이드슬랙스(...", R.drawable.rectangle_32_2))
        itemList.add(ProductData("6%", "40,800", "클래식 린넨 밴드팬츠", R.drawable.rectangle_32_3))
        itemList.add(ProductData("8%", "41,800", "[라인예술] 벨트 와이드...", R.drawable.rectangle_32_4))
        itemList.add(ProductData("", "23,000", "코튼 핀턱 와이드 팬츠", R.drawable.rectangle_32_5))
        itemList.add(ProductData("", "14,800", "프리밴딩pt", R.drawable.rectangle_32_6))
        itemList.add(ProductData("4%", "29,900", "골덴 하이웨스트 일자...", R.drawable.rectangle_32_7))
        itemList.add(ProductData("", "26,900", "롱 와이드 하이 면팬츠", R.drawable.rectangle_32_8))
        itemList.add(ProductData("13%", "47,000", "핀턱 골덴 와이드팬츠", R.drawable.rectangle_32_9))
        setProdRV(itemList, binding.rvOtherProduct)
        setProdRV(itemList, binding.rvRecommendProducts)
        return binding.root
    }

    private fun setProdRV(prodList: MutableList<ProductData>, view: RecyclerView) {
        val prodAdapter = ProductAdapter()
        prodAdapter.setItemList(prodList)
        view.addItemDecoration(RVItemDecoration())
        with(view) {
            adapter = prodAdapter
            setHasFixedSize(true)
        }
    }
}