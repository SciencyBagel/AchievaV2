package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_analyzer_activity.*

class AnalyzerActivity : AppCompatActivity() {

    object RecommendedActivities {
        const val RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS = 2.5
        const val RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS = 1.25
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_activity)

        //implement analzye button
        btnAnalyzeActivity.setOnClickListener {

            //make sure the textInputs are not empty
            if (!textInputModerate.text.toString().equals("") && !textInputVigorous.text.toString().equals(""))
            {

                val inputWeeklyModerateActivity = textInputModerate.text.toString().toFloat()
                val inputWeeklyVigorousActivity = textInputVigorous.text.toString().toFloat()


                //There are 4 scenarios:
                //1: User has unhealthy moderate activity, healthy vigorous activity
                //2: User has unhealthy moderate activity, unhealthy vigorous activity
                //3: User has healthy moderate activity, healthy vigorous activity
                //4: User has healthy moderate activity, unhealthy vigorous activity

                showAnalysisDialog(inputWeeklyModerateActivity, inputWeeklyVigorousActivity)
            }
            else
            {
                //user left at least one of the fields empty
                Toast.makeText(applicationContext,"Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showAnalysisDialog(inputWeeklyModerateActivity: Float, inputWeeklyVigorousActivity: Float) {

        var message: String = ""

        //check if user is at healthy activity levels for both moderate and vigorous aerobic activities
        if (inputWeeklyModerateActivity >= RecommendedActivities.RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS) {
            //healthy moderate activity
            message += "You are in the healthy range of weekly moderate aerobic activity" +
                    " (${RecommendedActivities.RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS} hours or more)."
        }
        else
        {
            //unhealthy moderate activity
            message += "You are in the unhealthy range of weekly moderate aerobic activity." +
                    " Go for ${RecommendedActivities.RECOMMENDED_WEEKLY_MODERATE_AEROBIC_ACTIVITY_HOURS} hours or more."

        }

        if (inputWeeklyVigorousActivity >= RecommendedActivities.RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS) {
            //healthy vigorous activity
            message += " Also, You are in the healthy range of weekly vigorous aerobic activity" +
                    " (${RecommendedActivities.RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS} hours or more)."
        }
        else {
            //unhealthy vigorous activity
            message += " Also, You are in the unhealthy range of weekly vigorous aerobic activity." +
                    " Go for ${RecommendedActivities.RECOMMENDED_WEEKLY_VIGOROUS_AEROBIC_ACTIVITY_HOURS} hours or more"
        }

        val dialog = DialogAnalysis(message)
        dialog.show(supportFragmentManager, "activity analysis dialog")
    }
}