package com.mindera.rocketscience.common

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    const val DATE_TIME_FORMAT_Month_Day = "MMM d, yyyy"
    const val DATE_TIME_FORMAT_FROM_API = "yyyy-MM-dd'T'HH:mm:ss"
    const val DATE_FORMAT_FOR_API_REQUEST = "MM/dd/yyyy"
    const val DATE_TIME_FORMAT_24HR_PERIOD = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    const val DATE_TIME_FORMAT_ZONED_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ssZ"
    const val DATE_TIME_FORMAT_ZONED_DATE_TIME_NO_SECONDS = "yyyy-MM-dd'T'HH:mm"
    const val DATE_FORMAT_DASHBOARD_VISIT_LIST = "EEE, MMM dd yyyy"
    const val DATE_FORMAT_SCHEDULE_NEW_TASK = "MMM dd, YYYY"
    const val TIME_FORMAT_12HR_PERIODS = "hh:mm a"
    const val DATE_FORMAT_FOR_DB_SEARCH = "yyyy-MM-dd"


    fun getDay(string : String) : String{

        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ).parse(string)
        val day  = DateUtils.getRelativeTimeSpanString(date.time, Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS)
        return day.toString()
    }

    fun getTime(string: String): String {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(string)
        return SimpleDateFormat(TIME_FORMAT_12HR_PERIODS).format(date).toString()
    }
}