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
        itemList.add(ProductData( "5%", "35,000", "핀턱롱와이드슬랙스(..."))
        itemList.add(ProductData( "9%", "40,800", "클래식 린넨 밴드팬츠"))
        itemList.add(ProductData( "", "41,800", "[라인예술] 벨트 와이드..."))
        itemList.add(ProductData( "", "23,000", "코튼 핀턱 와이드 팬츠"))
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