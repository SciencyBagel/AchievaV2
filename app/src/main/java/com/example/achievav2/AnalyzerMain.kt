package com.example.achievav2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_analyzer_main.*

class AnalyzerMain : AppCompatActivity() {

    var Sex: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_main)

        //LINK YOUR ACTIVITIES HERE

        //water analyzer
        button_water.setOnClickListener {
            val intent = Intent(applicationContext, AnalyzerWater::class.java)

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


    }
}