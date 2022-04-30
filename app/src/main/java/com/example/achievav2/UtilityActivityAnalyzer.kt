package com.example.achievav2

class UtilityActivityAnalyzer {

    private var message: String = ""
    private var analysisIsValid = true
    private var isModerateHealthy = true
    private var isVigorousHealthy = true

    private object RecommendedActivities {
        //in hours
        const val RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS = 2.5
        const val RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS = 1.25
    }

    constructor(weeklyModerateActivity: Double, weeklyVigorousActivity: Double) {
        //check if user is at healthy activity levels for both moderate and vigorous aerobic activities
        if (weeklyModerateActivity >= AnalyzerActivity.RecommendedActivities.RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS) {
            //healthy moderate activity
            isModerateHealthy = true
            message += "You are in the healthy range of weekly moderate aerobic activity" +
                    " (${RecommendedActivities.RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS} hours or more)."
        } else {
            //unhealthy moderate activity
            isModerateHealthy = false
            message += "You are in the unhealthy range of weekly moderate aerobic activity." +
                    " Go for ${RecommendedActivities.RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS} hours or more."

        }

        if (weeklyVigorousActivity >= AnalyzerActivity.RecommendedActivities.RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS) {
            //healthy vigorous activity
            isVigorousHealthy = true
            message += " Also, You are in the healthy range of weekly vigorous aerobic activity" +
                    " (${RecommendedActivities.RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS} hours or more)."
        } else {
            //unhealthy vigorous activity
            isVigorousHealthy = false
            message += " Also, You are in the unhealthy range of weekly vigorous aerobic activity." +
                    " Go for ${RecommendedActivities.RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS} hours or more"
        }

    }

    fun getResultMessage(): String {
        return message
    }

    fun isValid(): Boolean {
        return analysisIsValid
    }

    fun isModerateHealthy(): Boolean {
        return isModerateHealthy
    }

    fun isVigorousHealthy(): Boolean {
        return isVigorousHealthy
    }
}