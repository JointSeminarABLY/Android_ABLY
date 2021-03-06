package com.example.jointseminarably.detailproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.HorizontalItemDecoration
import com.example.jointseminarably.R
import com.example.jointseminarably.VerticalItemDecoration
import com.example.jointseminarably.databinding.FragmentDetailProductBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProductFragment : Fragment() {
    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding ?: throw error("view binding error")
    private val viewModel by viewModels<DetailProductViewModel>()
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
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setProductDetailInfo()
        addItemList()
        addOtherItemList()
        setProdRV(itemList, binding.rvRecommendProducts)
        setProdRV(otherItemList, binding.rvOtherProduct)

        setReviewRecyclerView()
        setShipInfoRecyclerView()
        loadShipInfo()
        setDeliveryPercentageRyclerView()
        setTabLayoutItemInfo()
    }

    private fun setProductDetailInfo() {
        viewModel.productList.observe(viewLifecycleOwner) { product ->
            viewModel.mapShippingInfo()
            binding.viewpagerProduct.run {
                adapter = ProductImageAdapter(product.image, this@DetailProductFragment)
                TabLayoutMediator(binding.tablayutDotIndicator, this) { tab, position ->
                }.attach()
            }
            (binding.rvReviewProduct.adapter as ReviewListAdapter).submitList(product.review)
            (binding.rvPercentage.adapter as DeliveryPercentageAdapter).submitList(product.deliveryPercentage)
            viewModel.changeDateDeliveryASAP(product.deliveryPercentage[0])
        }
    }

    private fun setDeliveryPercentageRyclerView() {
        binding.rvPercentage.apply {
            adapter = DeliveryPercentageAdapter()
            addItemDecoration(VerticalItemDecoration(6))
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

    private fun setTabLayoutItemInfo() {
        binding.itemInfoViewpager.apply {
            adapter = ProductInfoAdapter(this@DetailProductFragment)
            TabLayoutMediator(binding.tablayoutProduct, this) { tab, position ->
                when (position) {
                    0 -> tab.setText("????????????")
                    1 -> tab.setText("??????14")
                    2 -> tab.setText("??????/??????")
                }
            }.attach()
        }
    }

    private fun setProdRV(prodList: MutableList<ProductData>, view: RecyclerView) {
        val prodAdapter = ProductAdapter()
        prodAdapter.setItemList(prodList)
        view.addItemDecoration(RVItemDecoration(0, 5, 22, 5))
        view.isNestedScrollingEnabled = false
        with(view) {
            adapter = prodAdapter
            setHasFixedSize(true)
        }
    }

    private fun addItemList() {
        itemList.apply {
            add(ProductData("", "29,900", "?????????????????????(2color)", R.drawable.rectangle_32_1))
            add(ProductData("", "35,000", "???????????????????????????(...", R.drawable.rectangle_32_2))
            add(ProductData("6%", "40,800", "????????? ?????? ????????????", R.drawable.rectangle_32_3))
            add(ProductData("8%", "41,800", "[????????????] ?????? ?????????...", R.drawable.rectangle_32_4))
            add(ProductData("", "23,000", "?????? ?????? ????????? ??????", R.drawable.rectangle_32_5))
            add(ProductData("", "14,800", "????????????pt", R.drawable.rectangle_32_6))
            add(ProductData("4%", "29,900", "?????? ??????????????? ??????...", R.drawable.rectangle_32_7))
            add(ProductData("", "26,900", "??? ????????? ?????? ?????????", R.drawable.rectangle_32_8))
            add(ProductData("13%", "47,000", "?????? ?????? ???????????????", R.drawable.rectangle_32_9))
        }
    }

    private fun addOtherItemList() {
        otherItemList.apply {
            add(
                ProductData(
                    "5%",
                    "53,200",
                    "[????????????] #SLOWMA..",
                    R.drawable.rectangle_32_10
                )
            )
            add(ProductData("9%", "24,700", "[????????????/???????????????..", R.drawable.rectangle_32_11))
            add(ProductData("", "19,800", "[????????????/???????????????..", R.drawable.rectangle_32_12))
            add(ProductData("", "19,000", "[????????????/???????????????..", R.drawable.rectangle_32_13))
            add(ProductData("", "34,000", "[????????????/???????????????..", R.drawable.rectangle_32_14))
            add(ProductData("", "42,000", "[????????????/???????????????..", R.drawable.rectangle_32_15))
            add(ProductData("", "21,000", "[????????????] ????????? ??????..", R.drawable.rectangle_32_16))
            add(ProductData("", "31,000", "[????????????/????????????] S..", R.drawable.rectangle_32_17))
            add(ProductData("", "32,000", "[????????????] SOAN : ???..", R.drawable.rectangle_32_18))
        }
    }
}