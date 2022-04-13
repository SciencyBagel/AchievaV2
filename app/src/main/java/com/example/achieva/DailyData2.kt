package com.example.achieva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class DailyData2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_data2)

        //need to create and adapter for every array we need for the drop down menus
        //arrays can be found in "strings.xml"
        val scale = ArrayAdapter.createFromResource(this, R.array.Scale0_10, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        scale.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        val minutes = ArrayAdapter.createFromResource(this, R.array.Minutes, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        minutes.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        val sleep = ArrayAdapter.createFromResource(this, R.array.Sleep, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        sleep.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        val water = ArrayAdapter.createFromResource(this, R.array.Water, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        water.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        //find each drop down menu
        val exerciseAnswer = findViewById<Spinner>(R.id.sExerciseAnswer)
        val sleepAnswer = findViewById<Spinner>(R.id.sSleepAnswer)
        val waterAnswer = findViewById<Spinner>(R.id.sWaterAnswer)
        val screenAnswer = findViewById<Spinner>(R.id.sScreenTimeAnswer)
        val mealsAnswer = findViewById<Spinner>(R.id.sMealsAnswer)
        val fastFoodAnswer = findViewById<Spinner>(R.id.sFastFoodAnswer)
        val enjoyAnswer = findViewById<Spinner>(R.id.sEnjoyAnswer)
        val mentalAnswer = findViewById<Spinner>(R.id.sMentallyAnswer)
        val physicalAnswer = findViewById<Spinner>(R.id.sPhysicallyAnswer)

        //assign the appropriate scale for each question
        exerciseAnswer.adapter = minutes
        sleepAnswer.adapter = sleep
        waterAnswer.adapter = water
        screenAnswer.adapter = minutes
        mealsAnswer.adapter = scale
        fastFoodAnswer.adapter = scale
        enjoyAnswer.adapter = scale
        mentalAnswer.adapter = scale
        physicalAnswer.adapter = scale

        //find the submit button
        var submitData = findViewById<Button>(R.id.bSubmitData)

        //when the submit button is pressed display a success message and go back to the profile
        //this is where we would add the code to add there data to the database
        submitData.setOnClickListener()
        {
            Toast.makeText(this, "Data Uploaded!", Toast.LENGTH_LONG).show()
            val openProfile = Intent(this, Profile::class.java)
            startActivity(openProfile)
        }
    }
}