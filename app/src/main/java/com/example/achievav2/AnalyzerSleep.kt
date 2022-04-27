package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_analyzer_sleep.*

class AnalyzerSleep : AppCompatActivity() {

    var sleepHours: Int = 0
    var userAge:Int = 0

    //to show messages pertaining to age group
    enum class AgeGroup(ageRange: String) {
        SCHOOL_AGE("9-12 Hours"),
        TEEN("8-10 Hours"),
        ADULT("7 or more Hours");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_sleep)

        //implement seekBar and get information from it
        seekBarSleep.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvSleepHours.text = "$p1 Hours" //update textview to reflect the seekbar progress
                sleepHours = p1
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
            //get user info from textInputEditText
            userAge = textInputAge.text.toString().toInt()

            //make sure age is not empty
            if (!userAge.equals(""))
            {
                //below school age
                if (userAge < 6)
                {
                    Toast.makeText(applicationContext, "Too young to use this app. Sorry!", Toast.LENGTH_LONG).show()
                }
                //school age (6 <= age <= 12): 9-12 hours
                else if (userAge >= 6 && userAge <= 12)
                {
                    if (sleepHours >= 9 && sleepHours <= 12)
                    {
                        //in ideal sleep range
                        showGoodMessage()
                    }
                    else if (sleepHours < 9)
                    {
                        showBadMessageLow(AgeGroup.SCHOOL_AGE)
                    }
                    else if (sleepHours > 12)
                    {
                        showBadMessageHigh(AgeGroup.SCHOOL_AGE)
                    }
                }
                //teen (13 <= age <= 18): 8-10 hours
                else if (userAge >= 13 && userAge <= 18)
                {
                    if (sleepHours >= 8 && sleepHours <= 10)
                    {
                        //in ideal sleep range
                        showGoodMessage()
                    }
                    else if (sleepHours < 9)
                    {
                        //too low
                        showBadMessageLow(AgeGroup.TEEN)
                    }
                    else if (sleepHours > 10)
                    {
                        //too high
                        showBadMessageHigh(AgeGroup.TEEN)
                    }
                }
                //adult (age > 18): >= 7 hours
                else if (userAge > 18)
                {
                    if (sleepHours >= 7)
                    {
                        //in ideal sleep range
                        showGoodMessage()
                    }
                    else if (sleepHours < 7)
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
        var message: String = "You are sleeping below recommended amount: "

        if (ageGroup == AgeGroup.SCHOOL_AGE)
        {
            message += "9-12 Hours"
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
        else if (ageGroup == AgeGroup.TEEN)
        {
            message += "8-10 Hours"
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
        else if (ageGroup == AgeGroup.ADULT)
        {
            message += "7 or more Hours"
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }

    private fun showBadMessageHigh(ageGroup: AgeGroup) {
        var message: String = "You are above recommended amount: "

        if (ageGroup == AgeGroup.SCHOOL_AGE)
        {
            message += "9-12 Hours"
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
        else if (ageGroup == AgeGroup.TEEN)
        {
            message += "8-10 Hours"
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
        else if (ageGroup == AgeGroup.ADULT)
        {
            message += "7 or more Hours"
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }
}