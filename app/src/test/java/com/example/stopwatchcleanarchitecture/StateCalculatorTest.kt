package com.example.stopwatchcleanarchitecture

import com.example.stopwatchcleanarchitecture.calculation.ElapsedTimeCalculator
import com.example.stopwatchcleanarchitecture.calculation.TimestampProvider
import com.example.stopwatchcleanarchitecture.state.StopwatchState
import com.example.stopwatchcleanarchitecture.state.StopwatchStateCalculator
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class StateCalculatorTest {

    lateinit var stopwatchStateCalculator:StopwatchStateCalculator

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        stopwatchStateCalculator = StopwatchStateCalculator(
            timestampProvider,
            elapsedTimeCalculator
        )
    }

    @Mock
    lateinit var timestampProvider: TimestampProvider

    @Mock
    lateinit var elapsedTimeCalculator: ElapsedTimeCalculator


    @Test
    fun state_Run_Test1(){
        val state = stopwatchStateCalculator.calculateRunningState(
            StopwatchState.Running(10,10)
        )
        Assert.assertEquals(state, StopwatchState.Running(10,10))
    }

    @Test
    fun state_Run_Test2(){
        Mockito.`when`(timestampProvider.getMilliseconds()).thenReturn(101)

        val state = stopwatchStateCalculator.calculateRunningState(
            StopwatchState.Paused(100)
        )
        Assert.assertEquals(state,
            StopwatchState.Running(
                timestampProvider.getMilliseconds(),
             100))
    }

    @Test
    fun state_Pause1(){
        Mockito.`when`(elapsedTimeCalculator.calculate(
            StopwatchState.Running(0,10)
        )).thenReturn(10)
        val state = stopwatchStateCalculator.calculatePausedState(
            StopwatchState.Running(0,10))
        Assert.assertEquals(state, StopwatchState.Paused(10))
    }

    @Test
    fun state_Pause2(){
        val state = stopwatchStateCalculator.calculatePausedState(
            StopwatchState.Paused(10))
        Assert.assertEquals(state, StopwatchState.Paused(10))
    }






}