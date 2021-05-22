package com.example.jointseminarably.home.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.R
import com.example.jointseminarably.databinding.ItemRankingBinding
import com.example.jointseminarably.home.data.RankingItem

class RankingAdapter(
    private val activity: Activity,
    private val context: Context,
    private val items: MutableList<RankingItem>
) : RecyclerView.Adapter<RankingAdapter.RankingAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingAdapterVH {
        val itemBinding =
            ItemRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RankingAdapterVH(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RankingAdapter.RankingAdapterVH, position: Int) {
        val item: RankingItem = items[position]
        holder.bind(item)
    }

    inner class RankingAdapterVH(var binding: ItemRankingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RankingItem) {
            binding.imgvRankingImage.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    item.image
                )
            )
            binding.tvRankingPrice.text = item.price
            binding.tvRankingBrand.text = item.brandName
            binding.tvRankingName.text = item.productName

            when (item.like) {
                true -> {
                    binding.btnRankingHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline_true
                        )
                    )
                }
                false->{
                    binding.btnRankingHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline
                        )
                    )
                }
            }

            when (item.saleFlag){
                true->{
                    binding.tvRankingSalePercent.text = item.sale
                }
                false->{
                    binding.tvRankingSalePercent.visibility = View.GONE
                }
            }

            binding.btnRankingHeart.setOnClickListener{
                if(item.like){
                    binding.btnRankingHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline_true
                        )
                    )
                } else{
                    binding.btnRankingHeart.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_heart_outline
                        )
                    )
                }
                item.like = !item.like
            }
        }
    }
}