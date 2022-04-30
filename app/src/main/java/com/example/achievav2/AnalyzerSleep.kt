package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_analyzer_sleep.*
//signature test
class AnalyzerSleep : AppCompatActivity() {

    var sleepHours: Int = 0
    lateinit var userAgeInput: String
    var userAge: Int = 0

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
            //get user info from views
            userAgeInput = textInputAge.text.toString()

            if (!userAgeInput.equals("")) //make sure age is not empty
            {
                userAge = userAgeInput.toInt()
                sleepHours = seekBarSleep.progress //get seekbar progress

                //commence analysis
                val results = UtilitySleepAnalyzer(userAge, sleepHours)
                val message = results.getResultMessage()

                //show results
                val dialog = DialogAnalysis(message)
                dialog.show(supportFragmentManager, "sleep analysis")
            }
            else
            {
                Toast.makeText(applicationContext,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }
        }
    }
}