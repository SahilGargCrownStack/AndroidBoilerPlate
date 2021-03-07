package com.sahilgarg90.androidboilerplate.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Sahil Garg on 07-03-2021.
 */

object DateUtil {
    fun getDayOfMonthSuffix(day: Int?): String? {
        if (day != null && day in 1..31) {
            return if (day in 11..13) {
                "th"
            } else when (day % 10) {
                1 -> "st"
                2 -> "nd"
                3 -> "rd"
                else -> "th"
            }
        } else {
            throw IllegalArgumentException("illegal day of month: $day")
        }
    }

    fun convertDateFormat(patternFrom: String, patternTo: String, dateString: String = ""): String {
        val dateFormatFrom = SimpleDateFormat(patternFrom, Locale.getDefault())
        val dateFormatTo = SimpleDateFormat(patternTo, Locale.getDefault())
        try {
            val date = dateFormatFrom.parse(dateString)
            date?.let {
                return dateFormatTo.format(date)
            }
        } catch (e: ParseException) {
        }
        return dateString
    }

    /**
     * @param milliseconds - This should be the UNIX timestamp
     */
    fun createDateFormat(pattern: String, milliseconds: Long): String {
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        return dateFormat.format(Date(milliseconds * 1000))
    }

    /**
     * this - This should be the UNIX timestamp
     */
    fun Long.getDayAgoTime(): String? {
        val currentDateCalendar = Calendar.getInstance()
        val startDateCalendar = Calendar.getInstance()
        startDateCalendar.timeInMillis = this * 1000

        val millisecondsDifference = currentDateCalendar.time.time - startDateCalendar.time.time
        val dayLeft = millisecondsDifference / (24 * 60 * 60 * 1000)

        val timeString = when {
            dayLeft > 1 -> "$dayLeft days"
            dayLeft == 1.toLong() -> "$dayLeft day"
            else -> {
                when (val hourLeft = millisecondsDifference / (60 * 60 * 1000)) {
                    in 2..23 -> "$hourLeft hours"
                    1.toLong() -> "$hourLeft hour"
                    else -> {
                        when (val minuteLeft = millisecondsDifference / (60 * 1000)) {
                            in 2..59 -> "$minuteLeft mins"
                            1.toLong() -> "$minuteLeft min"
                            else -> "few secs"
                        }
                    }
                }
            }
        }

        return "$timeString ago"
    }
}