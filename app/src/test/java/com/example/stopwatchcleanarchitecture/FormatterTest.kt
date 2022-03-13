package com.example.stopwatchcleanarchitecture

import com.example.stopwatchcleanarchitecture.formatter.TimestampMillisecondsFormatter
import org.junit.Assert
import org.junit.Test


class FormatterTest {

    val formatter = TimestampMillisecondsFormatter()

    @Test
    fun test_Format1() {
        val meaning = formatter.format(1000)
        println(meaning)
        Assert.assertEquals(meaning, "00:01:00")
    }

    @Test
    fun test_Format2() {
        val meaning = formatter.format(100)
        println(meaning)
        Assert.assertEquals(meaning, "00:00:10")
    }

    @Test
    fun test_Format3() {
        val meaning = formatter.format(35912)
        println(meaning)
        Assert.assertEquals(meaning, "00:35:91")
    }

    @Test
    fun test_Format4() {
        val meaning = formatter.format(5400000)
        println(meaning)
        Assert.assertEquals(meaning, "01:30:00")
    }

    @Test
    fun test_Format5() {
        val meaning = formatter.format(10801000)
        println(meaning)
        Assert.assertEquals(meaning, "03:00:01")
    }


}