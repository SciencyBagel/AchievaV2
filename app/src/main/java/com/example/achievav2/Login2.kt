package com.example.achievav2

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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Login2 : AppCompatActivity()
{
    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val etUsername = findViewById<EditText>(R.id.viewUsernameText)
        val etPassword = findViewById<EditText>(R.id.viewPasswordText)
        val btLogin = findViewById<Button>(R.id.btnLogIn)
        val caText = findViewById<TextView>(R.id.tvSignupQuestion)
        //val fpText = findViewById<TextView>(R.id.textView3)

        //Create Instance of DBHandler
        //    val context = this
        //    val db = DataBaseHandler(context)
        //db.insertTestData()

        caText.setOnClickListener {
            caText.setTextColor(Color.BLUE)
            caText.setBackgroundColor(Color.GRAY)

            openCreateAccount()
        }

        /* fpText.setOnClickListener {
             fpText.setTextColor(Color.BLUE)
             fpText.setBackgroundColor(Color.GRAY)
             openForgotPassword()
         }*/

        //LOGIN BUTTON
        btLogin.setOnClickListener()
        {

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            hideMyKeyboard()

            //Check if user and password fields are not blank
            if(username.isNotEmpty() && password.isNotEmpty())
            {
                var testIt = ConnectLogin()
                val result = testIt.Async().execute(username, password).get()
                if(result > 0)
                {
                    Toast.makeText(applicationContext, "Login Successful!", Toast.LENGTH_LONG).show()

                    val intent =  Intent(this, AnalyzerMain::class.java)

                    //SEND IN USER ID # TO PERFORM ALL DATA TASKS ONCE LOGGED IN
                    intent.putExtra("Id", result)
                    startActivity(intent)
                    finish()
                }
                else
                    Toast.makeText(applicationContext, "Invalid Username or Password", Toast.LENGTH_LONG).show()
                //     }
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
            //   val context = this
            //     val db = DataBaseHandler(context)

            //       db.insertData(username!!, password!!, email!!)

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
        val intent = Intent(this,SignUp::class.java)
        //intent.putExtra("database",db)S
        startActivityForResult(intent,1)
    }

    private fun openForgotPassword(){
        val intent = Intent(this,ForgotPassword::class.java)
        startActivity(intent)
    }
}
