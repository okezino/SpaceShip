package com.mindera.rocketscience.data.model



data class LaunchDTOItem(
    val details: String,
    val flight_number: Int,
    val is_tentative: Boolean,
    val launch_date_local: String,
    val launch_date_unix: Int,
    val launch_date_utc: String,
    val launch_failure_details: LaunchFailureDetails,
    val launch_site: LaunchSite,
    val launch_success: Boolean,
    val launch_window: Int,
    val launch_year: String,
    val links: Links,
    val mission_id: List<String>,
    val mission_name: String,
    val rocket: Rocket,
    val ships: List<String>,
    val static_fire_date_unix: Int,
    val static_fire_date_utc: String,
    val tbd: Boolean,
    val telemetry: Telemetry,
    val tentative_max_precision: String,
    val timeline: Timeline,
    val upcoming: Boolean
)