package com.example.stopwatchcleanarchitecture.formatter

import java.math.RoundingMode
import java.text.DecimalFormat

class TimestampMillisecondsFormatter {

    fun format(timestamp: Long): String {
//        val df = DecimalFormat("##")
//        df.roundingMode = RoundingMode.CEILING
        val milliseconds = timestamp/10
        val millisecondsFormatted = (milliseconds % 100).pad(2)
        val seconds = timestamp / 1000
        val secondsFormatted = (seconds % 60).pad(2)
        val minutes = seconds / 60
        val minutesFormatted = (minutes % 60).pad(2)
        val hours = minutes / 60
        return if (hours > 0) {
            val hoursFormatted = (minutes / 60).pad(2)
            "$hoursFormatted:$minutesFormatted:$secondsFormatted"
        } else {
            "$minutesFormatted:$secondsFormatted:$millisecondsFormatted"
        }
    }

    private fun Long.pad(desiredLength: Int) = this.toString().padStart(desiredLength, '0')

    companion object {
        const val DEFAULT_TIME = "00:00:00"
    }

    fun testDel(){
        val num = 1.34567
//        println(df.format(num))
    }

}