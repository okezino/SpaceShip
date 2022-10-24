package com.mindera.rocketscience.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindera.rocketscience.R
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.databinding.LaunchViewItemBinding

class LaunchItemViewHolder(private val binding : LaunchViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(launchDTOItem: LaunchDTOItem){
        with(binding){
            if(launchDTOItem.launch_success){
                launchState.setImageResource(R.drawable.ic_baseline_check_24)
            }else launchState.setImageResource(R.drawable.ic_baseline_close_24)

            missionName.text = launchDTOItem.mission_name
            rocketName.text = "${launchDTOItem.rocket.rocket_name} / ${launchDTOItem.rocket.rocket_type}"
        }
    }
    companion object{
        fun from(parent: ViewGroup) : LaunchItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = LaunchViewItemBinding.inflate(layoutInflater, parent, false)
            return LaunchItemViewHolder(binding)
        }
    }
}