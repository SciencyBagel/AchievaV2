package com.example.achievav2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analyzer_main.*
import java.util.function.ToIntFunction

class AnalyzerMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_main)

        //Get User ID from Login This value needs to be passed with intent anywhere
        //Data access is required. Read or Write
        val Id = intent.getIntExtra("Id", 0)
        //Get Int from String if int needed
        val IdStr = Id.toString()

        //LINK YOUR ACTIVITIES HERE

        //water analyzer
        button_water.setOnClickListener {
            val intent = Intent(applicationContext, AnalyzerWater::class.java)

            //next 2 lines opens an activity and pauses it instead of creating new ones every time
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent, 0)
        }

        //activity analyzer
        button_activity.setOnClickListener {
            val intent = Intent(applicationContext, AnalyzerActivity::class.java)

            //next 2 lines opens an activity and pauses it instead of creating new ones every time
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent, 0)
        }

        //sleep analyzer
        button_sleep.setOnClickListener {
            val intent = Intent(applicationContext, AnalyzerSleep::class.java)

            //next 2 lines opens an activity and pauses it instead of creating new ones every time
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent, 0)
        }

        //User Profile
        button_userProfile.setOnClickListener {
            val intent =  Intent(this, UserProfile::class.java)
            intent.putExtra("Id", IdStr)
            startActivity(intent)
        }


    }
}