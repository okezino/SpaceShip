package com.mindera.rocketscience.data.model

data class Timeline(
    val beco: Int,
    val center_core_boostback: Int,
    val center_core_entry_burn: Int,
    val center_core_landing: Int,
    val center_stage_sep: Int,
    val dragon_bay_door_deploy: Int,
    val dragon_separation: Int,
    val dragon_solar_deploy: Int,
    val engine_chill: Int,
    val fairing_deploy: Int,
    val first_stage_boostback_burn: Int,
    val first_stage_entry_burn: Int,
    val first_stage_landing: Int,
    val go_for_launch: Int,
    val go_for_prop_loading: Int,
    val ignition: Int,
    val liftoff: Int,
    val maxq: Int,
    val meco: Int,
    val payload_deploy: Int,
    val payload_deploy_1: Int,
    val payload_deploy_2: Int,
    val prelaunch_checks: Int,
    val propellant_pressurization: Int,
    val rp1_loading: Int
)