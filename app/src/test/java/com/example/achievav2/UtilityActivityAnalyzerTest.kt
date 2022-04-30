package com.example.achievav2

import org.junit.Test
import org.junit.jupiter.api.Assertions.*


internal class UtilityActivityAnalyzerTest {

    @Test
    fun isModerateHealthy() {
        //testing for true negative: moderate activity is not healthy
        val unhealthyModerateActivity = 2.0
        val healthyVigorousActivity = 1.5
        val utility = UtilityActivityAnalyzer(unhealthyModerateActivity, healthyVigorousActivity)
        assertEquals(false, utility.isModerateHealthy())
    }

    @Test
    fun isVigorousHealthy() {
        //testing for true negative: vigorous activity is not healthy
        val healthyModerateActivity = 2.5
        val unhealthyVigorousActivity = 0.5
        val utility = UtilityActivityAnalyzer(healthyModerateActivity, unhealthyVigorousActivity)
        assertEquals(false, utility.isVigorousHealthy())
    }
}