package com.example.achievav2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val editName = findViewById<EditText>(R.id.etEditName)
        val username = editName.toString()
        val editHeight = findViewById<EditText>(R.id.etEditHeight)
        val feet = editHeight.toString()
        val editHeightInch = findViewById<EditText>(R.id.etEditHeightInch)
        val inch = editHeightInch.toString()
        val editWeight = findViewById<EditText>(R.id.etEditWeight)
        val weight = editWeight.toString()
        val editGender = findViewById<EditText>(R.id.etEditGender)
        val sex = editGender.toString()

        val submitButton = findViewById<Button>(R.id.bSaveProfile)
        //GET USER ID TO STORE INFO
        val userID = intent.getStringExtra("Id")

        //Unused right now
        val editPicture = findViewById<ImageView>(R.id.ivEditPicture)
        editPicture.setOnClickListener()
        {
            choosePhoto()
        }

        bEditProfile.setOnClickListener()
        {
            val IdStr = intent.getStringExtra("Id")
            var testIt = ConnectEditProfile()
            val userID = testIt.Async().execute(userID, username, feet, inch, weight, sex).get()
            if (userID != null) {
                Toast.makeText(this, "Update Successful", Toast.LENGTH_LONG).show()
//                openProfile(userID, userName, height, heightInch, weight, gender)
            }
        }
    }

    private fun openProfile(userID: Int, userName: String, feet: String, inch: String, weight: String, gender: String){
        val intent = Intent(this,UserProfile::class.java)
        intent.putExtra("userID", userID)
        intent.putExtra("userName",userName)
        intent.putExtra("feet", feet)
        intent.putExtra("inch", inch)
        intent.putExtra("weight", weight)
        intent.putExtra("gender", gender)
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