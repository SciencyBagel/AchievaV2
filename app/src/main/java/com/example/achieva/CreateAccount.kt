package com.example.achieva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        //val intent = getIntent()
        //val db: DataBaseHandler = intent.getSerializableExtra("database") as DataBaseHandler

        val newUsername = findViewById<EditText>(R.id.newUsername)
        val newPassword = findViewById<EditText>(R.id.newPassword)
        val newEmail = findViewById<EditText>(R.id.newEmail)
        val bCreateAccount = findViewById<Button>(R.id.bCreateAccount)

        bCreateAccount.setOnClickListener{
            val username = newUsername.text.toString()
            val password = newPassword.text.toString()
            val email = newEmail.text.toString()

            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("Username",username)
            intent.putExtra("Password",password)
            intent.putExtra("Email",email)
            setResult(1, intent)
            finish()


            //db.insertData(username,password,email)
        }
    }
}