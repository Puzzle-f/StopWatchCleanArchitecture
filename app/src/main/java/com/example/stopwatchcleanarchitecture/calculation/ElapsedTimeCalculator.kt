package com.example.stopwatchcleanarchitecture.calculation

import com.example.stopwatchcleanarchitecture.state.StopwatchState

class ElapsedTimeCalculator(
    private val timestampProvider: TimestampProvider
) {

    fun calculate(state: StopwatchState.Running): Long {
        val currentTimestamp = timestampProvider.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            state.startTime
        }
        return timePassedSinceStart + state.elapsedTime
    }
}
