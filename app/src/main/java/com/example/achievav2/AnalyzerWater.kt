package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_analyzer_water.*

class AnalyzerWater : AppCompatActivity() {

    //sex logic members
    private lateinit var rdioBtnSelected : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_water)

        //implement seekbar for the user to input their water intake
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvMilliLiters.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        //Analyze button implementation
        var btnAnalyze : Button = findViewById(R.id.btnAnalyze)
        btnAnalyze.setOnClickListener{
            var radioId : Int = sexRadioGroup.checkedRadioButtonId //give id of button we checked in radio group
            rdioBtnSelected = findViewById(radioId) //assign radio object with id given by radio group

            val userConsumption : Int = seekBar.progress //how many milliliters of water the user consumes

            finish()
        }
    }

    fun checkRdioBtn(v: View)
    {
        //This function shows user a toast message about their selected sex.

        var radioId : Int = sexRadioGroup.checkedRadioButtonId //give id of button we checked in radio group
        rdioBtnSelected = findViewById(radioId) //assign radio object with id given by radio group

        Toast.makeText(this, "Selected Radio Button: " + rdioBtnSelected.text, Toast.LENGTH_SHORT).show()
    }
}