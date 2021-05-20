package com.example.jointseminarably.home.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.databinding.ItemSpecialCategoryBinding
import com.example.jointseminarably.home.data.SpecialCategoryItem

class SpecialCategoryAdapter(
    private val activity: Activity,
    private val context: Context,
    private val items: MutableList<SpecialCategoryItem>
) : RecyclerView.Adapter<SpecialCategoryAdapter.SpecialAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialAdapterVH {
        val itemBinding =
            ItemSpecialCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpecialAdapterVH(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SpecialAdapterVH, position: Int) {
        val item: SpecialCategoryItem = items[position]
        holder.bind(item)
    }

    inner class SpecialAdapterVH(var binding: ItemSpecialCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: SpecialCategoryItem){
                binding.btnSpecialCategory.text = item.title
            }
    }
}