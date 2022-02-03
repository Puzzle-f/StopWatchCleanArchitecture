package com.example.stopwatchcleanarchitecture.calculation


interface TimestampProvider {
    fun getMilliseconds(): Long
}