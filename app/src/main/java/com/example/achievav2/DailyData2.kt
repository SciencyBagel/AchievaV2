package com.example.achievav2

//For system date time
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlin.text.toInt as toInt1

class DailyData2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
        val IdStr = intent.getStringExtra("Id")
        val IdInt = IdStr!!.toInt1()
        //assign the appropriate scale for each question
        exerciseAnswer.adapter = minutes
        sleepAnswer.adapter = sleep
        waterAnswer.adapter = water
        screenAnswer.adapter = minutes
        mealsAnswer.adapter = scale
        fastFoodAnswer.adapter = scale
        enjoyAnswer.adapter = minutes
        mentalAnswer.adapter = scale
        physicalAnswer.adapter = scale

        //find the submit button
        var submitData = findViewById<Button>(R.id.bSubmitData)

        //when the submit button is pressed display a success message and go back to the profile
        //this is where we would add the code to add there data to the database
        submitData.setOnClickListener()
        {
            val a1 = exerciseAnswer.selectedItemId.toInt()
            val a2 = sleepAnswer.selectedItemId.toInt()
            val a3 = waterAnswer.selectedItemId.toInt()
            val a4 = screenAnswer.selectedItemId.toInt()
            val a5 = mealsAnswer.selectedItemId.toInt()
            val a6 = fastFoodAnswer.selectedItemId.toInt()
            val a7 = enjoyAnswer.selectedItemId.toInt()
            val a8 = mentalAnswer.selectedItemId.toInt()
            val a9 = physicalAnswer.selectedItemId.toInt()
        //    val IdInt = IdStr?.toInt1()
//            val currentDate = LocalDateTime.now()
//            val profileUser = userName
//            val context = this
//            val db = DataBaseHandler(context)
//            db.updateDailyData(currentDate.toString(), a1.toInt(), a2.toInt(), a3.toInt(), a4.toInt(), a5.toInt(), a6.toInt(), a7.toInt(), a8.toInt(), a9.toInt())

            var testIt = ConnectSurvey()
            val userID = testIt.Async().execute(IdInt, a1, a2, a3, a4, a5, a6, a7, a8, a9).get()
            if (userID != null) {
                Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show()
                if (IdStr != null) {
                    openProfile(IdStr)
                }
            }

            //   val getUser = intent.getStringExtra("userName")
            //User is found with a successful username and password
            //Now we need to get all profile info and pass to the activity
 //           var data = userName?.let { it1 -> db.getProfileData(it1) }
/*
            val userID = data?.get(0)?.id.toString()
            val userName = data?.get(0)?.userName.toString()
            val password = data?.get(0)?.password.toString()
            val email = data?.get(0)?.email.toString()
            val age = data?.get(0)?.age.toString()
            val feet = data?.get(0)?.feet.toString()
            val inch = data?.get(0)?.inch.toString()
            val weight = data?.get(0)?.weight.toString()
            val gender = data?.get(0)?.gender.toString()
            val completedSurvey = data?.get(0)?.completedSurvey.toString()
            val lastSurvey = data?.get(0)?.lastSurvey.toString()
            val privacy = data?.get(0)?.privacy.toString()
            val premium = data?.get(0)?.premium.toString()
//            val openProfile = Intent(this, Profile2::class.java)

 */
            /*
            openProfile.putExtra("userID", userID)
            openProfile.putExtra("userName",userName)
            openProfile.putExtra("password", password)
            openProfile.putExtra("email", email)
            openProfile.putExtra("age", age)
            openProfile.putExtra("feet", feet)
            openProfile.putExtra("inch", inch)
            openProfile.putExtra("weight", weight)
            openProfile.putExtra("gender", gender)
            openProfile.putExtra("completedSurvey", completedSurvey)
            openProfile.putExtra("lastSurvey", lastSurvey)
            openProfile.putExtra("privacy", privacy)
            openProfile.putExtra("premium", premium)

             */
     //       startActivity(openProfile)
        }
    }
    private fun openProfile(IdStr: String){
        val intent = Intent(this,UserProfile::class.java)
        intent.putExtra("Id", IdStr)

        startActivity(intent)
    }
}