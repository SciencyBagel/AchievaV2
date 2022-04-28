package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_analyzer_water.*

class AnalyzerWater : AppCompatActivity() {
    //progressbar
    //lateinit var textView: TextView

    //sex logic members
    private lateinit var rdioBtnSelected : RadioButton
    val MALE_RECOMMENDED_AMOUNT_OF_WATER: Int = 3700
    val FEMALE_RECOMMENDED_AMOUNT_OF_WATER: Int = 2700

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_water)

        //implement seekbar for the user to input their water intake
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //p1 is the progress of the seekbar when it was changed
                tvMilliLiters.text = "$p1 mL" //update the textview below seekbar

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }
        })

        //Analyze button implementation
        var btnAnalyze : Button = findViewById(R.id.btnAnalyze)
        btnAnalyze.setOnClickListener{
            //radio button info
            var radioId : Int = sexRadioGroup.checkedRadioButtonId //give id of button we checked in radio group
            rdioBtnSelected = findViewById(radioId) //assign radio object with id given by radio group
            val sex = rdioBtnSelected.text
            var message: String = ""

            //progressbar info
            val userConsumption : Int = seekBar.progress //how many milliliters of water the user consumes
            if (sex.equals("Male"))
            {
                if (userConsumption < MALE_RECOMMENDED_AMOUNT_OF_WATER - 150) //allow some wiggle room of 150mL of water
                {
                    message = "You need to drink more water. Go for around " +
                            MALE_RECOMMENDED_AMOUNT_OF_WATER.toString() + "mL of water."
                }
                else
                {
                    message = "You are drinking plenty of water. Good job!"
                }
            }
            else if (sex.equals("Female"))
            {
                if (userConsumption < FEMALE_RECOMMENDED_AMOUNT_OF_WATER - 150) //allow some wiggle room of 150mL of water
                {
                    message = "You need to drink more water. Go for around " +
                            FEMALE_RECOMMENDED_AMOUNT_OF_WATER.toString() + "mL of water."
                }
                else
                {
                    message = "You are drinking plenty of water. Good job!"
                }
            }

            val dialog = DialogAnalysis(message)
            dialog.show(supportFragmentManager, "water analysis results")
        }
    }

    fun checkRdioBtn(v: View)
    {
        //This function shows user a toast message about their selected sex.
        // It is defined to be called in the activity_analyzer_water.xml file in the radio buttons

        var radioId : Int = sexRadioGroup.checkedRadioButtonId //give id of button we checked in radio group
        rdioBtnSelected = findViewById(radioId) //assign radio object with id given by radio group

        //used to debug rdio buttons
        //Toast.makeText(this, "Selected Radio Button: " + rdioBtnSelected.text, Toast.LENGTH_SHORT).show()
    }
}