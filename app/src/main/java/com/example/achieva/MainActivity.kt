package com.example.achieva

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity()
{
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btLogin = findViewById<Button>(R.id.bLogin)
        val caText = findViewById<TextView>(R.id.textView2)
        val fpText = findViewById<TextView>(R.id.textView3)

        //Create Instance of DBHandler
        val context = this
        val db = DataBaseHandler(context)
        //db.insertTestData()

        caText.setOnClickListener {
            caText.setTextColor(Color.BLUE)
            caText.setBackgroundColor(Color.GRAY)

            openCreateAccount()

            //caText.setTextColor(Color.HSVToColor(floatArrayOf(199F,99F,96F)))
            //caText.setBackgroundColor(Color.TRANSPARENT)
        }

        fpText.setOnClickListener {
            fpText.setTextColor(Color.BLUE)
            fpText.setBackgroundColor(Color.GRAY)

            openForgotPassword()
        }

        btLogin.setOnClickListener()
        {

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            hideMyKeyboard()

            //Check if user and password fields are not blank
            if(username.isNotEmpty() && password.isNotEmpty())
            {
                val found = db.checkUserNamePass(username, password)

                if(found){
                    //user is found with a successful username and password
                    //now we need to get all the profile info and pass to the activity
                    var data = db.getProfileData(username)
                    //send data into activity

                    val intent =  Intent(this, Profile2::class.java)
                    startActivity(intent)

                }
            }



        }


    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == 1) {
            var email = data?.getStringExtra("Email")
            var username = data?.getStringExtra("Username")
            var password = data?.getStringExtra("Password")

            //Create Instance of DBHandler
            val context = this
            val db = DataBaseHandler(context)

            db.insertData(username!!, password!!, email!!)

        }
    }

    private fun hideMyKeyboard(){
        val view = this.currentFocus
        if(view != null) {
            val hideMe = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken, 0)
        }
        //else
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

    }

    private fun openCreateAccount(){
        val intent = Intent(this,CreateAccount::class.java)
        //intent.putExtra("database",db)S
        startActivityForResult(intent,1)
    }

    private fun openForgotPassword(){
        val intent = Intent(this,ForgotPassword::class.java)
        startActivity(intent)
    }
}