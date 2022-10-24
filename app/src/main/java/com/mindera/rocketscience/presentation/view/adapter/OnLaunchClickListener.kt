package com.mindera.rocketscience.presentation.view.adapter

import com.mindera.rocketscience.data.model.LaunchDTOItem

interface OnLaunchClickListener {
  fun   onItemClick(launchDTOItem: LaunchDTOItem)
}