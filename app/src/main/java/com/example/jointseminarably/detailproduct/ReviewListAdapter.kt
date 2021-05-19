package com.example.jointseminarably.detailproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.BR
import com.example.jointseminarably.databinding.ItemReviewProductBinding

class ReviewListAdapter: ListAdapter<ReviewModel, ReviewListAdapter.ReviewViewHolder>(
    diffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemReviewProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.setVariable(BR.data, item)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ReviewModel>(){
            override fun areItemsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
            override fun areContentsTheSame(oldItem: ReviewModel, newItem: ReviewModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ReviewViewHolder(val binding: ItemReviewProductBinding): RecyclerView.ViewHolder(binding.root)
}