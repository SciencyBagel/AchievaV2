package com.example.achievav2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.vishnusivadas.advanced_httpurlconnection.PutData


class SignUp : AppCompatActivity() {

    lateinit var textInputEditTextFullname: TextInputEditText
    lateinit var textInputEditTextEmail: TextInputEditText
    lateinit var textInputEditUsername: TextInputEditText
    lateinit var textInputEditPassword: TextInputEditText
    lateinit var btnSignUp : Button
    lateinit var textViewSignUpQuestion : TextView

    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //initialize widget objects and link to views
        textInputEditTextFullname = findViewById(R.id.viewFullnameText)
        textInputEditTextEmail = findViewById(R.id.viewEmailText)
        textInputEditUsername = findViewById(R.id.viewUsernameText)
        textInputEditPassword = findViewById(R.id.viewPasswordText)
        btnSignUp = findViewById(R.id.btnSignUp)
        textViewSignUpQuestion = findViewById(R.id.tvSignupQuestion)

        progressBar = findViewById(R.id.progressBar)

        //implement signup button
        btnSignUp.setOnClickListener {
            //- get string from InputEditTexts -
            var fullname : String = textInputEditTextFullname.text.toString()
            var email : String = textInputEditTextEmail.text.toString()
            var username : String = textInputEditUsername.text.toString()
            var password :String = textInputEditPassword.text.toString()

            //Make sure no field is left empty. If not empty, proceed.
            if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {
                progressBar.visibility = View.VISIBLE //show progress bar

                //====================================
                //Setup HTTP connection to MySQL server - Write Data
                //====================================
                //Start ProgressBar first (Set visibility VISIBLE)
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    //- Starting Write and Read data with URL -
                    //Creating array for parameters
                    val field =
                        arrayOfNulls<String>(4) //create field array of size 4 (one for each parameter)
                    field[0] = "fullname"
                    field[1] = "username"
                    field[2] = "password"
                    field[3] = "email"

                    //- Creating array for data -
                    val data = arrayOfNulls<String>(4)
                    data[0] = fullname
                    data[1] = email
                    data[2] = username
                    data[3] = password

                    //setup IPv4 address and compile data into putData to be sent
                    val IPv4 : String = "172.16.13.106" //type your IPv4 address here if you want to test application
                    val putData = PutData(
                        "http://$IPv4/LoginRegister/signup.php",
                        "POST",
                        field,
                        data
                    )

                    //====================================
                    //Execute HTTP send of Sign Up information
                    //====================================
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.visibility = View.GONE
                            val result = putData.result
                            if (result.equals("Sign Up Success")) //if sign up is successful
                            {
                                /* "Sign Up Success" message is received from the code signup.php in the apache server %/xampp/htdocs/LoginRegister */
                                Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()

                                var intent = Intent(applicationContext, Login::class.java) //intent to go to Login activity
                                startActivity(intent) //start Login Activity
                                finish() //finish this activity
                            }
                            else {
                                Toast.makeText(applicationContext, result, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    //End Write and Read data with URL
                }
            }
            else { //user did not enter all information required
                Toast.makeText(applicationContext, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}