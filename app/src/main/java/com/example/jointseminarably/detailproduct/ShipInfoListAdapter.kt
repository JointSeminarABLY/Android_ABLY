package com.example.jointseminarably.detailproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jointseminarably.BR
import com.example.jointseminarably.databinding.ItemShipInfoBinding

class ShipInfoListAdapter: ListAdapter<ShipInfoModel, ShipInfoListAdapter.ShipInfoViewHolder>(
    diffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipInfoViewHolder {
        val binding = ItemShipInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShipInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShipInfoViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.setVariable(BR.data, item)
    }


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ShipInfoModel>(){
            override fun areItemsTheSame(oldItem: ShipInfoModel, newItem: ShipInfoModel): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: ShipInfoModel,
                newItem: ShipInfoModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ShipInfoViewHolder(val binding: ItemShipInfoBinding): RecyclerView.ViewHolder(binding.root)
}