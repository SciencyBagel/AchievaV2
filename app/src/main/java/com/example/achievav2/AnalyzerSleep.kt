package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_analyzer_sleep.*
//signature test
class AnalyzerSleep : AppCompatActivity() {

    var sleepHoursInput: Int = 0
    lateinit var userAgeInput: String
    var userAge: Int = 0

    //to show messages pertaining to age group
    enum class AgeGroup(val ageRange: String, val minAge: Int, val maxAge: Int, val minSleep: Int, val maxSleep: Int) {
        SCHOOL_AGE("9-12 Hours", 6, 12, 9, 12),
        TEEN("8-10 Hours", 13, 18, 8, 10),
        ADULT("7 or more Hours", 19, 60, 7, Int.MAX_VALUE);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_sleep)

        //implement seekBar and get information from it
        seekBarSleep.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvSleepHours.text = "$p1 Hours" //update textview to reflect the seekbar progress
                sleepHoursInput = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }

        })

        //implement analyzeSleep button
        btnAnalyzeSleep.setOnClickListener {
            //get user info from views
            userAgeInput = textInputAge.text.toString()
            sleepHoursInput = seekBarSleep.progress

            //make sure age is not empty
            if (!userAgeInput.equals(""))
            {
                userAge = userAgeInput.toInt()

                //below school age
                if (userAge < AgeGroup.SCHOOL_AGE.minAge)
                {
                    Toast.makeText(applicationContext, "Too young to use this app. Sorry!", Toast.LENGTH_LONG).show()
                }
                //SCHOOL AGE: (6 <= age <= 12): 9-12 hours
                else if (userAge >= AgeGroup.SCHOOL_AGE.minAge && userAge <= AgeGroup.SCHOOL_AGE.maxAge)
                {
                    if ((sleepHoursInput >= AgeGroup.SCHOOL_AGE.maxSleep) && (sleepHoursInput <= AgeGroup.SCHOOL_AGE.maxSleep))
                    {
                        //in ideal sleep range (test)
                        showGoodMessage()
                    }
                    else if (sleepHoursInput < AgeGroup.SCHOOL_AGE.minSleep)
                    {
                        showBadMessageLow(AgeGroup.SCHOOL_AGE)
                    }
                    else if (sleepHoursInput > AgeGroup.SCHOOL_AGE.maxSleep)
                    {
                        showBadMessageHigh(AgeGroup.SCHOOL_AGE)
                    }
                }
                //TEEN: (13 <= age <= 18): 8-10 hours
                else if (userAge >= AgeGroup.TEEN.minAge && userAge <= AgeGroup.TEEN.maxAge)
                {
                    if (sleepHoursInput >= AgeGroup.TEEN.minSleep && sleepHoursInput <= AgeGroup.TEEN.maxSleep)
                    {
                        //in ideal sleep range
                        showGoodMessage()
                    }
                    else if (sleepHoursInput < AgeGroup.TEEN.minSleep)
                    {
                        //too low
                        showBadMessageLow(AgeGroup.TEEN)
                    }
                    else if (sleepHoursInput > AgeGroup.TEEN.maxSleep)
                    {
                        //too high
                        showBadMessageHigh(AgeGroup.TEEN)
                    }
                }
                //ADULT: (age > 19): >= 7 hours
                else if (userAge > AgeGroup.ADULT.minAge)
                {
                    if (sleepHoursInput >= AgeGroup.ADULT.minSleep)
                    {
                        //in ideal sleep range
                        showGoodMessage()
                    }
                    else if (sleepHoursInput < AgeGroup.ADULT.maxSleep)
                    {
                        showBadMessageLow(AgeGroup.ADULT)
                    }
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showGoodMessage() {
        Toast.makeText(applicationContext, "You are sleeping the recommended amount of time!", Toast.LENGTH_LONG).show()
    }

    private fun showBadMessageLow(ageGroup: AgeGroup) {
        var message: String = "You are sleeping below recommended amount: " + ageGroup.ageRange
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private fun showBadMessageHigh(ageGroup: AgeGroup) {
        var message: String = "You are above recommended amount: " + ageGroup.ageRange
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}