package com.example.achievav2

class UtilityWaterAnalyzer {


    private var analysisIsValid = true
    private var message: String = ""
    private var isHealthy = false

    private object RecommendedWater {
        //in mL
        const val MALE_RECOMMENDED_AMOUNT_OF_WATER: Int = 3700
        const val FEMALE_RECOMMENDED_AMOUNT_OF_WATER: Int = 2700
    }

    constructor(mlUserConsumption: Int, sex: String) {

        if (sex == "Male")
        {
            if (mlUserConsumption < RecommendedWater.MALE_RECOMMENDED_AMOUNT_OF_WATER - 150) //allow some wiggle room of 150mL of water
            {
                isHealthy = false
                message = "You need to drink more water. Go for around " +
                        RecommendedWater.MALE_RECOMMENDED_AMOUNT_OF_WATER.toString() + "mL of water."
            }
            else
            {
                isHealthy = true
                message = "You are drinking plenty of water. Good job!"
            }
        }
        else if (sex == "Female")
        {
            if (mlUserConsumption < RecommendedWater.FEMALE_RECOMMENDED_AMOUNT_OF_WATER - 150) //allow some wiggle room of 150mL of water
            {
                isHealthy = false
                message = "You need to drink more water. Go for around " +
                        RecommendedWater.FEMALE_RECOMMENDED_AMOUNT_OF_WATER.toString() + "mL of water."
            }
            else
            {
                isHealthy = true
                message = "You are drinking plenty of water. Good job!"
            }
        }
        else {
            message = "Error: "
            if (sex != "Male" || sex != "Female") {
                message += "Unknown sex $sex"
            }
            analysisIsValid = false
        }
    }

    fun getResultMessage(): String {
        return message
    }

    fun isValid(): Boolean {
        return analysisIsValid
    }

    fun isHealthy(): Boolean {
        return isHealthy
    }

}