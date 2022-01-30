package com.example.stopwatchcleanarchitecture.state


interface TimestampProvider {
    fun getMilliseconds(): Long
}