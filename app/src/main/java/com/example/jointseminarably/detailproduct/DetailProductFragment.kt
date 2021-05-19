package com.example.jointseminarably.detailproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.R
import com.example.jointseminarably.VerticalItemDecoration
import com.example.jointseminarably.databinding.FragmentDetailProductBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProductFragment : Fragment() {
    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding ?: throw error("view binding error")
    private val itemList = mutableListOf<ProductData>()
    private val otherItemList = mutableListOf<ProductData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProductDetailInfo()
        addItemList()
        addOtherItemList()
        setProdRV(itemList, binding.rvRecommendProducts)
        setProdRV(otherItemList, binding.rvOtherProduct)

        setReviewRecyclerView()
        setShipInfoRecyclerView()
        loadShipInfo()
    }

    private fun setProductDetailInfo() {
        viewModel.productList.observe(viewLifecycleOwner) { product ->
            viewModel.mapShippingInfo()
            binding.viewpagerProduct.run {
                adapter = ProductImageAdapter(product.image, this@DetailProductFragment)
                TabLayoutMediator(binding.tablayutDotIndicator, this) { tab,position ->
                }.attach()
            }
            (binding.rvReviewProduct.adapter as ReviewListAdapter).submitList(product.review)
        }
    }

    }

    private fun setShipInfoRecyclerView() {
        binding.rvShipInfo.apply {
            adapter = ShipInfoListAdapter()
            addItemDecoration(VerticalItemDecoration(19))
        }
    }

    private fun loadShipInfo() {
        viewModel.shipInfo.observe(viewLifecycleOwner) {
            (binding.rvShipInfo.adapter as ShipInfoListAdapter).submitList(it)
        }
    }

    private fun setReviewRecyclerView() {
        binding.rvReviewProduct.apply {
            adapter = ReviewListAdapter()
            addItemDecoration(HorizontalItemDecoration(14))
        }
    }

    private fun setProdRV(prodList: MutableList<ProductData>, view: RecyclerView) {
        val prodAdapter = ProductAdapter()
        prodAdapter.setItemList(prodList)
        view.addItemDecoration(RVItemDecoration())
        view.isNestedScrollingEnabled = false
        with(view) {
            adapter = prodAdapter
            setHasFixedSize(true)
        }
    }

    private fun addItemList() {
        itemList.add(ProductData("", "29,900", "내츄럴린넨펜츠(2color)", R.drawable.rectangle_32_1))
        itemList.add(ProductData("", "35,000", "핀턱롱와이드슬랙스(...", R.drawable.rectangle_32_2))
        itemList.add(ProductData("6%", "40,800", "클래식 린넨 밴드팬츠", R.drawable.rectangle_32_3))
        itemList.add(ProductData("8%", "41,800", "[라인예술] 벨트 와이드...", R.drawable.rectangle_32_4))
        itemList.add(ProductData("", "23,000", "코튼 핀턱 와이드 팬츠", R.drawable.rectangle_32_5))
        itemList.add(ProductData("", "14,800", "프리밴딩pt", R.drawable.rectangle_32_6))
        itemList.add(ProductData("4%", "29,900", "골덴 하이웨스트 일자...", R.drawable.rectangle_32_7))
        itemList.add(ProductData("", "26,900", "롱 와이드 하이 면팬츠", R.drawable.rectangle_32_8))
        itemList.add(ProductData("13%", "47,000", "핀턱 골덴 와이드팬츠", R.drawable.rectangle_32_9))
    }

    private fun addOtherItemList() {
        otherItemList.add(
            ProductData(
                "5%",
                "53,200",
                "[무료배송] #SLOWMA..",
                R.drawable.rectangle_32_10
            )
        )
        otherItemList.add(ProductData("9%", "24,700", "[무료배송/베스트재입..", R.drawable.rectangle_32_11))
        otherItemList.add(ProductData("", "19,800", "[무료배송/베스트재입..", R.drawable.rectangle_32_12))
        otherItemList.add(ProductData("", "19,000", "[무료배송/베스트재입..", R.drawable.rectangle_32_13))
        otherItemList.add(ProductData("", "34,000", "[무료배송/베스트재입..", R.drawable.rectangle_32_14))
        otherItemList.add(ProductData("", "42,000", "[무료배송/베스트재입..", R.drawable.rectangle_32_15))
        otherItemList.add(ProductData("", "21,000", "[무료배송] 데이즈 크롭..", R.drawable.rectangle_32_16))
        otherItemList.add(ProductData("", "31,000", "[무료배송/당일발송] S..", R.drawable.rectangle_32_17))
        otherItemList.add(
            ProductData(
                "",
                "32,000",
                "[무료배송] SOAN : 홈..",
                R.drawable.rectangle_32_18
            )
        )
    }
}