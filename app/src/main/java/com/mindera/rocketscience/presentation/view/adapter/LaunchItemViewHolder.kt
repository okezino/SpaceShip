package com.mindera.rocketscience.presentation.view.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindera.rocketscience.R
import com.mindera.rocketscience.common.DateUtil
import com.mindera.rocketscience.data.model.LaunchDTOItem
import com.mindera.rocketscience.databinding.LaunchViewItemBinding
import java.text.SimpleDateFormat
import java.util.*

class LaunchItemViewHolder(private val binding : LaunchViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, launchDTOItem: LaunchDTOItem, onLaunchClickListener: OnLaunchClickListener){
        with(binding){
            if(launchDTOItem.launch_success){
                launchState.setImageResource(R.drawable.ic_baseline_check_24)
            }else launchState.setImageResource(R.drawable.ic_baseline_close_24)




            missionName.text = launchDTOItem.mission_name
            rocketName.text = context.getString(R.string.rocket_name, launchDTOItem.rocket.rocket_name, launchDTOItem.rocket.rocket_type)
            dateTime.text = context.getString(R.string.date_and_time, DateUtil.getDay(launchDTOItem.launch_date_utc), DateUtil.getTime(launchDTOItem.launch_date_utc))

            linearLayout.setOnClickListener {
                onLaunchClickListener.onItemClick(launchDTOItem)
            }
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