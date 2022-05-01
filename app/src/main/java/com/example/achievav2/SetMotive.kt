package com.example.achievav2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class SetMotive : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motive_survey)

        //Set up submission
        var submitMotive = findViewById<Button>(R.id.motiveSubmit_btn)

        //Setting up check boxes
        val mq1 = findViewById<CheckBox>(R.id.body_check)
        val mq2 = findViewById<CheckBox>(R.id.mind_check)
        val mq3 = findViewById<CheckBox>(R.id.weight_check)
        val mq4 = findViewById<CheckBox>(R.id.otherHealth_check)
        val mq5 = findViewById<CheckBox>(R.id.affirm_check)
        val mq6 = findViewById<CheckBox>(R.id.community_check)
        val mq7 = findViewById<CheckBox>(R.id.selOther_check)



        val IdStr = intent.getStringExtra("Id")
        val IdInt = IdStr?.toInt()
        var m1 = 0
        var m2 = 0
        var m3 = 0
        var m4 = 0
        var m5 = 0
        var m6 = 0
        var m7 = 0
        submitMotive.setOnClickListener()
        {
            val mq1 = findViewById<CheckBox>(R.id.body_check)
            if(mq1.isChecked())
                m1 = 1
            else
                m1 = 0
            val mq2 = findViewById<CheckBox>(R.id.mind_check)
            if(mq2.isChecked())
                m2 = 1
            else
                m2 = 0
            val mq3 = findViewById<CheckBox>(R.id.weight_check)
            if(mq1.isChecked())
                m3 = 1
            else
                m3 = 0
            val mq4 = findViewById<CheckBox>(R.id.otherHealth_check)
            if(mq1.isChecked())
                m4 = 1
            else
                m4 = 0
            val mq5 = findViewById<CheckBox>(R.id.affirm_check)
            if(mq1.isChecked())
                m5 = 1
            else
                m5 = 0
            val mq6 = findViewById<CheckBox>(R.id.community_check)
            if(mq1.isChecked())
                m6 = 1
            else
                m6 = 0
            val mq7 = findViewById<CheckBox>(R.id.selOther_check)
            if(mq1.isChecked())
                m7 = 1
            else
                m7 = 0
            var testIt = ConnectMotive()
            val result = testIt.Async().execute(IdInt, m1, m2, m3, m4, m5, m6, m7).get()
            if(result)
                Toast.makeText(applicationContext, "Motives Stored", Toast.LENGTH_LONG).show()
            if (IdStr != null) {
                openProfile(IdStr)
            }
        //            val openProfile = Intent(this, Profile2::class.java)
//            var data = userName?.let { it1 -> db.getProfileData(it1) }
//
            //Get User Info
//            val userID2 = data?.get(0)?.id.toString()
//            val userName = data?.get(0)?.userName.toString()
//            val feet = data?.get(0)?.feet.toString()
//            val inch = data?.get(0)?.inch.toString()
//            val weight = data?.get(0)?.weight.toString()
//            val gender = data?.get(0)?.gender.toString()


            //Update Table
 //           val userID = userID?.toInt()
//            db.updateM(userID.toString())
//            db.updateMotive(userID.toString(), mq1.isChecked(),mq2.isChecked(),mq3.isChecked(),mq4.isChecked(),mq5.isChecked(),mq6.isChecked(),mq7.isChecked())
 //           if (userID != null) {
//                openProfile(userID, userName, feet, inch, weight, gender)
//            }

//            openProfile.putExtra("userID", userID2)
//            openProfile.putExtra("userName",userName)
//            openProfile.putExtra("feet", feet)
//            openProfile.putExtra("inch", inch)
 //           openProfile.putExtra("weight", weight)
//            openProfile.putExtra("gender", gender)

 //           startActivity(openProfile)
        }
    }
    fun openProfile(IdStr: String){
        val intent = Intent(this,UserProfile::class.java)
        intent.putExtra("Id", IdStr)

        startActivity(intent)
    }
    /*
    private fun openProfile(userID: Int, userName: String, feet: String, inch: String, weight: String, gender: String){
   //     val intent = Intent(this,Profile2::class.java)
        intent.putExtra("userID", userID)
        intent.putExtra("userName",userName)
        intent.putExtra("feet", feet)
        intent.putExtra("inch", inch)
        intent.putExtra("weight", weight)
        intent.putExtra("gender", gender)
        startActivity(intent)
    }

     */
}