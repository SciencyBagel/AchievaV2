package com.example.achieva

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
Profile screen is work in progress. I assumed some info we would have on it and maybe a profile picture
The white space seen in "profile.xml" i figured we would use to display the users past data, and where
their suggestions would pop up
*/

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

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
            //val openDataEntry = Intent(this, DailyData::class.java)
           // startActivity(openDataEntry)
        }

    }
}