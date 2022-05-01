package com.example.achievav2

class UtilitySleepAnalyzer(userAge: Int, sleepHours: Int) {

    private enum class SleepQuality {
        GOOD_SLEEP,
        BAD_SLEEP_LOW,
        BAD_SLEEP_HIGH
    }

    //holds info about age groups and sleep requirements
    private enum class AgeGroup(val sleepRange: String, val minAge: Int, val maxAge: Int, val minSleep: Int, val maxSleep: Int) {
        UNDER_AGE("undefined", Int.MIN_VALUE, 5, 0, 0),
        SCHOOL_AGE("9-12 Hours", 6, 12, 9, 12),
        TEEN("8-10 Hours", 13, 18, 8, 10),
        ADULT("7 or more Hours", 19, 60, 7, Int.MAX_VALUE);
    }

    private var ageGroup = AgeGroup.SCHOOL_AGE
    private var sleepQuality = SleepQuality.BAD_SLEEP_LOW
    private var analysisIsValid = true
    private var isHealthy = true

    init {

        if (userAge < AgeGroup.SCHOOL_AGE.minAge)
        {
            ageGroup = AgeGroup.UNDER_AGE
            analysisIsValid = false
        }
        //SCHOOL AGE: (6 <= age <= 12): 9-12 hours
        else if (userAge >= AgeGroup.SCHOOL_AGE.minAge && userAge <= AgeGroup.SCHOOL_AGE.maxAge)
        {
            ageGroup = AgeGroup.SCHOOL_AGE
            if ((sleepHours >= AgeGroup.SCHOOL_AGE.minSleep) && (sleepHours <= AgeGroup.SCHOOL_AGE.maxSleep))
            {
                //in ideal sleep range (test)
                sleepQuality = SleepQuality.GOOD_SLEEP
                isHealthy = true
            }
            else if (sleepHours < AgeGroup.SCHOOL_AGE.minSleep)
            {
                sleepQuality = SleepQuality.BAD_SLEEP_LOW
                isHealthy = false
            }
            else if (sleepHours > AgeGroup.SCHOOL_AGE.maxSleep)
            {
                sleepQuality = SleepQuality.BAD_SLEEP_HIGH
                isHealthy = false
            }
        }
        //TEEN: (13 <= age <= 18): 8-10 hours
        else if (userAge >= AgeGroup.TEEN.minAge && userAge <= AgeGroup.TEEN.maxAge)
        {
            ageGroup = AgeGroup.TEEN
            if (sleepHours >= AgeGroup.TEEN.minSleep && sleepHours <= AgeGroup.TEEN.maxSleep)
            {
                //in ideal sleep range
                sleepQuality = SleepQuality.GOOD_SLEEP
                isHealthy = true
            }
            else if (sleepHours < AgeGroup.TEEN.minSleep)
            {
                //too low
                sleepQuality = SleepQuality.BAD_SLEEP_LOW
                isHealthy = false
            }
            else if (sleepHours > AgeGroup.TEEN.maxSleep)
            {
                //too high
                sleepQuality = SleepQuality.BAD_SLEEP_HIGH
                isHealthy = false
            }
        }
        //ADULT: (age > 19): >= 7 hours
        else if (userAge >= AgeGroup.ADULT.minAge)
        {
            ageGroup = AgeGroup.ADULT
            if (sleepHours >= AgeGroup.ADULT.minSleep)
            {
                //in ideal sleep range
                sleepQuality = SleepQuality.GOOD_SLEEP
                isHealthy = true
            }
            else if (sleepHours < AgeGroup.ADULT.maxSleep)
            {
                sleepQuality = SleepQuality.BAD_SLEEP_LOW
                isHealthy = false

            }
        }
    }

    fun getResultMessage(): String{
        var message = ""
        if (analysisIsValid) {

            message += when (sleepQuality) {
                SleepQuality.GOOD_SLEEP -> "You are sleeping the recommended amount of time!"
                SleepQuality.BAD_SLEEP_LOW -> "You are sleeping below recommended amount: " + ageGroup.sleepRange
                SleepQuality.BAD_SLEEP_HIGH -> "You are above recommended amount: " + ageGroup.sleepRange
            }
        }
        else {
            message += "Error: "

            if (ageGroup == AgeGroup.UNDER_AGE) {
                message += "Sorry, you are too young to use this analyzer."
            }
            else {
                message += "Unexpected."
            }
        }

        return message
    }

    fun isValid(): Boolean{
        return analysisIsValid
    }

    fun isHealthy(): Boolean {
        return isHealthy
    }

}