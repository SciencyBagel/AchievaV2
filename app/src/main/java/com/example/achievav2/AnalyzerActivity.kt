package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_analyzer_water.*

class AnalyzerActivity : AppCompatActivity() {
    lateinit var rdioBtnSelected: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analyzer_activity)

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