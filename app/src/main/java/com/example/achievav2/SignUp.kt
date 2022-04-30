package com.example.achievav2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception
import java.sql.DriverManager

class SignUp : AppCompatActivity() {

    lateinit var textInputEditTextFullname: TextInputEditText
    lateinit var textInputEditTextEmail: TextInputEditText
    lateinit var textInputEditUsername: TextInputEditText
    lateinit var textInputEditPassword: TextInputEditText
    lateinit var btnSignUp : Button
    lateinit var textViewSignUpQuestion : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        data class User(val fullname: String, val email: String, val username: String, val password: String)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //initialize widget objects and link to views
        textInputEditTextFullname = findViewById(R.id.viewFullnameText)
        textInputEditTextEmail = findViewById(R.id.viewEmailText)
        textInputEditUsername = findViewById(R.id.viewUsernameText)
        textInputEditPassword = findViewById(R.id.viewPasswordText)
        btnSignUp = findViewById(R.id.btnSignUp)
        textViewSignUpQuestion = findViewById(R.id.tvLoginQuestion)

        //implement signup button
        btnSignUp.setOnClickListener {
            //- get string from InputEditTexts -
            val fullname : String = textInputEditTextFullname.text.toString()
            val email : String = textInputEditTextEmail.text.toString()
            val username : String = textInputEditUsername.text.toString()
            val password :String = textInputEditPassword.text.toString()
            val User = User(fullname, email, username, password) //store data in user class

            //Make sure no field is left empty. If not empty, proceed.
            if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {
                var testIt = ConnectSignUp()
                val result = testIt.Async().execute(fullname, email, username, password).get()
                if(result)
                    Toast.makeText(applicationContext, "Account Created", Toast.LENGTH_LONG).show()
                //====================================
                //Database Driver
                //====================================
                //connection setup
                val hostname = "achieva.cdrswrihk4uf.us-east-2.rds.amazonaws.com"
                val port = "3306"
                val dbname = "ACHIEVA"
                val dbuser = "admin"
                val dbpassword = "TjX6c5wtsOUg"
                val jdbcURL = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname


                //query setup
                val queryString =
                    "INSERT INTO Users " +
                            "(fullname, email, username, password) " +
                            "VALUES " +
                            "("+User.fullname+","+User.email+","+User.username+","+User.password+")"

                //try to connect
                try {
                    progressBar.visibility = View.VISIBLE
                    //connection attempt
                    val connection = DriverManager.getConnection(jdbcURL, dbuser, dbpassword)
                    val query = connection.prepareStatement(queryString)

                    //query execution
                    val result = query.executeUpdate()

                    //checking if it query execution was successful
                    if (result == 0) {
                        //no rows affected -> error
                        connection.close()

                        Toast.makeText(applicationContext, "Error: Sign Up Failure", Toast.LENGTH_LONG).show()
                    }
                    else {
                        //rows affected > success
                        connection.close()
                        Toast.makeText(applicationContext, "Sign Up Successful!", Toast.LENGTH_SHORT).show()

                        //now switch to login context
                        val intent = Intent(this,Login2::class.java)
                        intent.putExtra("Username",username)
                        intent.putExtra("Password",password)
                        //intent.putExtra("Email",email)
                        setResult(1, intent)
                        finish()
                    }
                }
                catch (e: Exception)
                {
                    Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
                finally {
                    progressBar.visibility = View.GONE
                }


            }
            else { //user did not enter all information required
                Toast.makeText(applicationContext, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}