package com.example.jointseminarably.home.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.ItemRecommendProductBinding
import com.example.jointseminarably.home.data.RecommendItem

class RecommendAdapter(
    private val activity: Activity,
    private val context: Context,
    private val items: MutableList<RecommendItem>
) : RecyclerView.Adapter<RecommendAdapter.RecommendAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendAdapterVH {
        val itemBinding =
            ItemRecommendProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendAdapterVH(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecommendAdapterVH, position: Int) {
        val item: RecommendItem = items[position]
        holder.bind(item)
    }

    inner class RecommendAdapterVH(var binding: ItemRecommendProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecommendItem) {
            binding.imgvRecommendImage.setImageDrawable(ContextCompat.getDrawable(context, item.image))
            binding.tvRecommendBrand.text = item.brandName
            binding.tvRecommendName.text = item.productName
            binding.tvRecommendPrice.text = item.price
            binding.tvRecommendCount.text = "리뷰 ${item.reviewCount} - 만족도 ${item.satisfaction}%"

            when(item.like){
                true->{
                    binding.btnRecommendHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline_true
                        )
                    )
                }
                false->{
                    binding.btnRecommendHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline
                        )
                    )
                }
            }

            when(item.saleFlag){
                true->{
                    binding.tvRecommendSalePercent.text = item.sale
                }
                false->{
                    binding.tvRecommendSalePercent.visibility = View.GONE
                }
            }

            binding.btnRecommendHeart.setOnClickListener {
                if (item.like) {
                    binding.btnRecommendHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline
                        )
                    )
                } else {
                    binding.btnRecommendHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline_true
                        )
                    )
                }
                item.like = !item.like
            }
        }
    }
}