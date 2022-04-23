package com.example.achievav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class AnalyzerWater : AppCompatActivity() {

    private lateinit var radioGroup : RadioGroup
    private lateinit var radioButton : RadioButton
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        radioGroup = findViewById(R.id.sexRadioGroup)
        textView = findViewById(R.id.tvSexPrompt)

        var btnAnalyze : Button = findViewById(R.id.btnAnalyze)
        btnAnalyze.setOnClickListener{
            var radioId : Int = radioGroup.checkedRadioButtonId //give id of button we checked in radio group
            radioButton = findViewById(radioId) //assign radio object with id given by radio group
        }
    }

    fun checkButton(v: View)
    {
        //This function shows user a toast message about their selected sex.

        var radioId : Int = radioGroup.checkedRadioButtonId //give id of button we checked in radio group
        radioButton = findViewById(radioId) //assign radio object with id given by radio group

        Toast.makeText(this, "Selected Radio Button: " + radioButton.text, Toast.LENGTH_SHORT).show()
    }
}