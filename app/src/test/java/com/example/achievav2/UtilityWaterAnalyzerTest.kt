package com.example.achievav2

import org.junit.Test
import org.junit.jupiter.api.Assertions.*


internal class UtilityWaterAnalyzerTest {

    @Test
    fun isHealthy() {
        val mlUserConsumption = 3000
        val sex = "Male"
        val utility = UtilityWaterAnalyzer(mlUserConsumption, sex)
        assertEquals(false, utility.isHealthy())
    }
}