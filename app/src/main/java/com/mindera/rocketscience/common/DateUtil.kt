package com.mindera.rocketscience.common

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    const val DATE_TIME_FORMAT_24HR_PERIOD = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val TIME_FORMAT_12HR_PERIODS = "hh:mm a"



    fun getDay(string : String) : String{

        val date = SimpleDateFormat(DATE_TIME_FORMAT_24HR_PERIOD ).parse(string)
        val day  = DateUtils.getRelativeTimeSpanString(date.time, Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS)
        return day.toString()
    }

    fun getTime(string: String): String {
        val date = SimpleDateFormat(DATE_TIME_FORMAT_24HR_PERIOD).parse(string)
        return SimpleDateFormat(TIME_FORMAT_12HR_PERIODS).format(date).toString()
    }
}