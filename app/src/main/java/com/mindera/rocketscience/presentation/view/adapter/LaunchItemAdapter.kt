package com.mindera.rocketscience.presentation.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mindera.rocketscience.data.model.LaunchDTOItem

class LaunchItemAdapter : ListAdapter<LaunchDTOItem, LaunchItemViewHolder>(LaunchUtilCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchItemViewHolder {
        return LaunchItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: LaunchItemViewHolder, position: Int) {
        val launch = currentList[position]
        holder.bind(launch)
    }
}