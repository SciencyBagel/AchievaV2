package com.example.achievav2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.nfc.tech.NfcA
import android.view.View
import android.widget.ImageView
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_analyzer_main.*
import kotlinx.android.synthetic.main.activity_profile.*

class UserProfile : AppCompatActivity() {

    var editUserID = ""
    var editUserName = ""
    var editPassword = ""
    var editHeight = ""
    var editWeight = ""

    //Need to either make this a drop down menu and pick male or female
    //or update database to change to varchar type
    var editGender = ""
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)


        //these lines find the text fields on the screen so we can change the text
        val profileName: TextView = findViewById<TextView>(R.id.tvDisplayName)
        val userHeight: TextView = findViewById<TextView>(R.id.tvHeightData)
        val userWeight: TextView = findViewById<TextView>(R.id.tvWeightData)
        val userGender: TextView = findViewById<TextView>(R.id.tvGenderData)

        var buttonEditPro = findViewById<Button>(R.id.bEditProfile)
        var gotoSetMotive = findViewById<Button>(R.id.setMotive_btn)
        var gotoDataEntry = findViewById<Button>(R.id.bEnterData)

        val IdStr = intent.getStringExtra("Id")
        var testIt = ConnectProfile()
        val userArray = testIt.Async().execute(IdStr).get()
        profileName.text = userArray[0]
        userWeight.text = userArray[1]
        if (userArray[2] == "1")
            userGender.text = "Male"
        else if (userArray[2] == "2")
            userGender.text = "Female"
        val height = userArray[3] + "' " + userArray[4] + "\""
        userHeight.text = height

        //Recommendation Code Here

        /*
        if (db.qRows("Surveys") > 0)
        {
            //Check Survey Vals
            val a1 = (db.translateData("A1", "Surveys").toInt() * 10/db.qRows("Surveys")) //Excercise
            val a2 = (db.translateData("A2", "Surveys").toInt() * 3/db.qRows("Surveys"))  //Sleep
            val a3 = (db.translateData("A3", "Surveys").toInt()+2 * 2/db.qRows("Surveys"))  //Water
            val a4 = (db.translateData("A4", "Surveys").toInt() * 10/db.qRows("Surveys")) //Screen
            val a5 = (db.translateData("A5", "Surveys").toInt()/db.qRows("Surveys")) //Meal
            val a6 = (db.translateData("A6", "Surveys").toInt()/db.qRows("Surveys")) //FastFood
            val a7 = (db.translateData("A7", "Surveys").toInt() * 10/db.qRows("Surveys")) //EnjoyedTime
            val a8 = db.translateData("A8", "Surveys").toInt()/db.qRows("Surveys") //PhysHealth
            val a9 = db.translateData("A9", "Surveys").toInt()/db.qRows("Surveys") //MentalHealth

            //Generate Random Val
            val rnd = (1..9).random()

            when (rnd)
            {
                1 -> if(a1 < 35)
                {
                    rec.setText("Get a bit more excercise!")
                }

                2 -> if(a2 < 8)
                {
                    rec.setText("You fix your sleep schedule...")
                }

                3 -> if(a3 < 12)
                {
                    rec.setText("You should drink more water!")
                }

                4 -> if(a4 > 480)
                {
                    rec.setText("You should go outside!")
                }

                5 -> if(a5 > 4)
                {
                    rec.setText("Eat a bit less...")
                }

                6 -> if(a6 > 1)
                {
                    rec.setText("Eat more home-made meals!")
                }

                7 -> if(a7 < 120)
                {
                    rec.setText("You should go unwind")
                }

                8 -> if(a8 < 5)
                {
                    rec.setText("I am you should call/find a gym buddy!")
                }

                9 -> if(a9 < 5)
                {
                    rec.setText("It might be a good idea to seek therapy...")
                }
            }
        }

//Just example data for the profile screen
//        userHeight.text = "6'0"
//        userWeight.text = "200lbs"
//        userGender.text = "Male"

        //find the button
        var gotoDataEntry = findViewById<Button>(R.id.bEnterData)
        var gotoSetMotive = findViewById<Button>(R.id.setMotive_btn)
        var gotoStat = findViewById<Button>(R.id.stat_btn)


        gotoStat.setOnClickListener()
        {
            val openStat = Intent(this, ViewStats::class.java)
            startActivity(openStat)
        }

        gotoSetMotive.setOnClickListener()
        {
            openMotive()
        }

        //when the button is pressed go to data entry screen
        gotoDataEntry.setOnClickListener()
        {
            //     val editUserName = intent.getStringExtra("userName").toString()

            val openDataEntry = Intent(this, DailyData2::class.java)
            openDataEntry.putExtra("userID", editUserID)
            openDataEntry.putExtra("userName", editUserName)
            openDataEntry.putExtra("password", editPassword)
            startActivity(openDataEntry)
        }

        var gotoEditProfile = findViewById<ImageView>(R.id.ivEditProfile)

        gotoEditProfile.setOnClickListener()
        {
            openEditProfile()
        }

    }
*/
        //Dailies
        gotoDataEntry.setOnClickListener()
        {
            val intent = Intent(applicationContext, DailyData2::class.java)

            //next 2 lines opens an activity and pauses it instead of creating new ones every time
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            intent.putExtra("Id", IdStr)
            startActivityIfNeeded(intent, 0)
        }
        //motive
        gotoSetMotive.setOnClickListener()
        {
            val intent = Intent(applicationContext, SetMotive::class.java)

            //next 2 lines opens an activity and pauses it instead of creating new ones every time
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            intent.putExtra("Id", IdStr)
            startActivityIfNeeded(intent, 0)
        }
        //User Profile Edit
        buttonEditPro.setOnClickListener()
        {
            val intent = Intent(applicationContext, EditProfile::class.java)

            //next 2 lines opens an activity and pauses it instead of creating new ones every time
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            intent.putExtra("Id", IdStr)
            startActivityIfNeeded(intent, 0)
            //     if (IdStr != null) {
            //         openEditProfile(IdStr)
            //     }
        }
    }
    /*
     fun openMotive(){
        val intent = Intent(this, SetMotive::class.java)
        //intent.putExtra("database",db)
        intent.putExtra("userID", editUserID)
        intent.putExtra("userName", editUserName)
        intent.putExtra("password", editPassword)
        //     intent.putExtra("height", editHeight)
        //    intent.putExtra("weight", editWeight)
        //     intent.putExtra("gender", editGender)
        startActivity(intent)
    }
*/

    }




