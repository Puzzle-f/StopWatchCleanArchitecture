package com.example.stopwatchcleanarchitecture.calculation


val timestampProvider = object : TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}