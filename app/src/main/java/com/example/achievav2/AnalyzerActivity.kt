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

                val inputWeeklyModerateActivity = textInputModerate.text.toString().toDouble()
                val inputWeeklyVigorousActivity = textInputVigorous.text.toString().toDouble()


                //There are 4 scenarios:
                //1: User has unhealthy moderate activity, healthy vigorous activity
                //2: User has unhealthy moderate activity, unhealthy vigorous activity
                //3: User has healthy moderate activity, healthy vigorous activity
                //4: User has healthy moderate activity, unhealthy vigorous activity

                //analyze
                val analysisUtility = UtilityActivityAnalyzer(inputWeeklyModerateActivity, inputWeeklyVigorousActivity)

                //get results
                val message = analysisUtility.getResultMessage()

                //display results
                val dialog = DialogAnalysis(message)
                dialog.show(supportFragmentManager, "activity analysis dialog")
            }
            else
            {
                //user left at least one of the fields empty
                Toast.makeText(applicationContext,"Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}