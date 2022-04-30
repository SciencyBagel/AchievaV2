package com.example.achievav2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_profile.*

class EditProfile : AppCompatActivity() {
    lateinit var textInputEditTextUsername: TextInputEditText
    lateinit var textInputEditTextFeet: TextInputEditText
    lateinit var textInputEditInch: TextInputEditText
    lateinit var textInputEditWeight: TextInputEditText
    lateinit var textInputEditSex: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        textInputEditTextUsername = findViewById(R.id.etEditName)
        textInputEditTextFeet = findViewById(R.id.etEditHeight)
        textInputEditInch = findViewById(R.id.etEditHeightInch)
        textInputEditWeight = findViewById(R.id.etEditWeight)
        textInputEditSex = findViewById(R.id.etEditGender)

        val submitButton = findViewById<Button>(R.id.bSaveProfile)
        //GET USER ID TO STORE INFO
        val userID = intent.getStringExtra("Id")

        //Unused right now
        val editPicture = findViewById<ImageView>(R.id.ivEditPicture)
        editPicture.setOnClickListener()
        {
            choosePhoto()
        }

        submitButton.setOnClickListener()
        {
            val IdStr = intent.getStringExtra("Id")
            val username : String = textInputEditTextUsername.text.toString()
            val feet : String = textInputEditTextFeet.text.toString()
            val inch : String = textInputEditInch.text.toString()
            val weight :String = textInputEditWeight.text.toString()
            val sex :String = textInputEditSex.text.toString()
            var testIt = ConnectEditProfile()
            val userID = testIt.Async().execute(userID, username, feet, inch, weight, sex).get()
            if (userID != null) {
                Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show()
                if (IdStr != null) {
                    openProfile(IdStr)
                }
            }
        }
    }

    private fun openProfile(IdStr: String){
        val intent = Intent(this,UserProfile::class.java)
        intent.putExtra("Id", IdStr)

        startActivity(intent)
    }
    private fun choosePhoto(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == 200 && data != null)
        {

            var selectedImage: Uri = data.data!!

            val editPicture = findViewById<ImageView>(R.id.ivEditPicture)
            editPicture.setImageURI(selectedImage)

        }
    }

}