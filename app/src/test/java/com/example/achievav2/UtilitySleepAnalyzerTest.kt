package com.example.achievav2

import org.junit.Test
import org.junit.jupiter.api.Assertions.*



internal class UtilitySleepAnalyzerTest {

    @Test
    fun isHealthy() {
        //testing for true negative: adult person is not sleeping enough
        val age = 19
        val sleep = 6
        val utility = UtilitySleepAnalyzer(age, sleep)
        assertEquals(false, utility.isHealthy())
    }
}