package com.example.jointseminarably.detailproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.BR
import com.example.jointseminarably.databinding.ItemPercentageDeliveryBinding

class DeliveryPercentageAdapter: ListAdapter<DeliveryPercentageModel, DeliveryPercentageAdapter.DeliverPercentageViewHolder>(
    diffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliverPercentageViewHolder {
        val binding = ItemPercentageDeliveryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeliverPercentageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliverPercentageViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            setVariable(BR.data, item)
            tvPercentage.append("%")
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DeliveryPercentageModel>() {
            override fun areItemsTheSame(
                oldItem: DeliveryPercentageModel,
                newItem: DeliveryPercentageModel
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: DeliveryPercentageModel,
                newItem: DeliveryPercentageModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
    class DeliverPercentageViewHolder(val binding: ItemPercentageDeliveryBinding): RecyclerView.ViewHolder(binding.root)
}