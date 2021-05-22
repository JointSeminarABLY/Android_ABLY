package com.example.jointseminarably.home.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.databinding.ItemFashionCategoryBinding
import com.example.jointseminarably.home.data.FashionCategoryItem

class FashionCategoryAdapter(private val items: MutableList<FashionCategoryItem>) : RecyclerView.Adapter<FashionCategoryAdapter.FashionAdapterVH>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FashionCategoryAdapter.FashionAdapterVH {
        val itemBinding =
            ItemFashionCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FashionAdapterVH(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FashionAdapterVH, position: Int) {
        val item: FashionCategoryItem = items[position]
        holder.bind(item)
    }

    inner class FashionAdapterVH(var binding: ItemFashionCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FashionCategoryItem){
            binding.btnFashionCategory.text = item.title
        }
    }
}