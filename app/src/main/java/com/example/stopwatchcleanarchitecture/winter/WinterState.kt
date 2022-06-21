package com.example.stopwatchcleanarchitecture.winter


var isWinter: Boolean = false
var isMoved: Boolean = true

//sealed class StopwatchState {
//
//    data class Paused(
//        val elapsedTime: Long
//    ) : StopwatchState()
//
//    data class Running(
//        val startTime: Long,
//        val elapsedTime: Long
//    ) : StopwatchState()
//}