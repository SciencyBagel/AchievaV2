package com.example.achieva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class Profile2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile2)

        //these lines find the text fields on the screen so we can change the text
        val profileName: TextView = findViewById<TextView>(R.id.tvDisplayName)
        val userHeight: TextView = findViewById<TextView>(R.id.tvHeightData)
        val userWeight: TextView = findViewById<TextView>(R.id.tvWeightData)
        val userGender: TextView = findViewById<TextView>(R.id.tvGenderData)

        //Just example data for the profile screen
        profileName.text = "John Doe"
        userHeight.text = "6'0"
        userWeight.text = "200lbs"
        userGender.text = "Male"

        //find the button
        var gotoDataEntry = findViewById<Button>(R.id.bEnterData)

        //when the button is pressed go to data entry screen
        gotoDataEntry.setOnClickListener()
        {
            val openDataEntry = Intent(this, DailyData2::class.java)
             startActivity(openDataEntry)
        }
    }
}