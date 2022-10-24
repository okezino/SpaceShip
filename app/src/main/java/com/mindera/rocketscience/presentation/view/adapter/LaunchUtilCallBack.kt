package com.mindera.rocketscience.presentation.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mindera.rocketscience.data.model.LaunchDTOItem

class LaunchUtilCallBack() : DiffUtil.ItemCallback<LaunchDTOItem>() {
    override fun areItemsTheSame(oldItem: LaunchDTOItem, newItem: LaunchDTOItem): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LaunchDTOItem, newItem: LaunchDTOItem): Boolean {
        return oldItem.mission_id == newItem.mission_id
    }
}