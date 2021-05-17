package com.example.jointseminarably.detailproduct

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.ItemProductBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var itemList = mutableListOf<ProductData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemProductBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_product, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun setItemList(newList: List<ProductData>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productData: ProductData) {
            binding.product = productData
            if (productData.discount.isNotEmpty()) {
                binding.tvDiscount.visibility = View.VISIBLE
            }
            onHeartClickListener(productData)
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        private fun onHeartClickListener(productData: ProductData) {
            with(binding) {
                ivHeart.setOnClickListener {
                    if (!productData.clicked) {
                        ivHeart.setImageDrawable(ivHeart.context.getDrawable(R.drawable.ic_heart_outline))
                        productData.clicked = true
                    } else {
                        ivHeart.setImageDrawable(ivHeart.context.getDrawable(R.drawable.icon_heart_outline))
                        productData.clicked = false
                    }
                }
            }
        }
    }
}