package com.example.achieva


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

//Database
const val DATABASE_NAME = "AchievaDB"
const val DATABASE_VERSION = 2 //This value is to be changed to upgrade DB.

//Tables
const val TABLE_USERS = "Users"
const val TABLE_SURVEYS = "Surveys"
//Combined answers and questions into one table
//const val TABLE_SURVEY_ANSWERS = "SurveyAnswers"
//const val TABLE_SURVEY_QUESTIONS = "SurveyQuestions"
const val TABLE_ANALYSIS = "Analysis"
const val TABLE_RECOMMENDATIONS = "Recommendations"

//User Columns
const val COL_USERNAME = "UserName"
const val COL_PASSWORD = "Password"
const val COL_EMAIL = "Email"
const val COL_ID = "id"
const val COL_AGE = "Age"
const val COL_HEIGHT_FEET = "Feet"
const val COL_HEIGHT_INCH = "Inch"
const val COL_WEIGHT = "Weight"
const val COL_GENDER = "Gender" //Int as bool. 0 = Male. 1 = Female
const val COL_SURVEYS_COMPLETED = "CompletedSurveys"
const val COL_LAST_COMPLETED_SURVEY = "LastCompletedSurvey" //Text as TIMESTAMP
//Privacy and Premium will default to 0. These will be implemented as we continue to update our data
//analysis features, as well as once we transition from a locally stored database to cloud server
const val COL_ISPRIVACY = "Privacy" //Int as bool. 0 = Not private. 1 = Private
const val COL_ISPREMIUM = "Premium" //Int as bool. 0 = Not premium. 1 = Premium

//Survey Columns
const val COL_SURVEYID = "SurveyID"
const val COL_SURVEY_CREATE_DATE = "CreateDate"
const val COL_SURVEY_COMPLETE_DATE = "CompleteDate"
const val COL_Q1 = "Q1"
const val COL_Q2 = "Q2"
const val COL_Q3 = "Q3"
const val COL_Q4 = "Q4"
const val COL_Q5 = "Q5"
const val COL_Q6 = "Q6"
const val COL_Q7 = "Q7"
const val COL_Q8 = "Q8"
const val COL_Q9 = "Q9"
const val COL_Q10 = "Q10"
const val COL_Q11 = "Q11"
const val COL_Q12 = "Q12"
const val COL_Q13 = "Q13"
const val COL_Q14 = "Q14"
const val COL_Q15 = "Q15"
const val COL_Q16 = "Q16"
const val COL_Q17 = "Q17"
const val COL_Q18 = "Q18"
const val COL_Q19 = "Q19"
const val COL_Q20 = "Q20"
const val COL_A1 = "A1"
const val COL_A2 = "A2"
const val COL_A3 = "A3"
const val COL_A4 = "A4"
const val COL_A5 = "A5"
const val COL_A6 = "A6"
const val COL_A7 = "A7"
const val COL_A8 = "A8"
const val COL_A9 = "A9"
const val COL_A10 = "A10"
const val COL_A11 = "A11"
const val COL_A12 = "A12"
const val COL_A13 = "A13"
const val COL_A14 = "A14"
const val COL_A15 = "A15"
const val COL_A16 = "A16"
const val COL_A17 = "A17"
const val COL_A18 = "A18"
const val COL_A19 = "A19"
const val COL_A20 = "A20"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION)
    {
    //Override function used when device does not contain database
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_USERS +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_USERNAME + " VARCHAR(256)," +
                COL_PASSWORD +" VARCHAR(256)," +
                COL_EMAIL +" VARCHAR(256))"

        db?.execSQL(createTable)

    }

    //For upgrading db version
    //If needing to modify database past the current version use
    //if(oldversion < +1 to current)
    //Make sure to modify const val of DATABASE_VERSION (+1 also)
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
        {
        if(oldVersion < 2)
            {
                //Add in columns to User table
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_AGE INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_HEIGHT_FEET INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_HEIGHT_INCH INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_WEIGHT INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_GENDER INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_SURVEYS_COMPLETED INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_LAST_COMPLETED_SURVEY TEXT")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_ISPRIVACY INTEGER")
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD $COL_ISPREMIUM INTEGER")

                //Add in new table Surveys
            val createTable = "CREATE TABLE $TABLE_SURVEYS ($COL_SURVEYID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "$COL_SURVEY_CREATE_DATE TEXT, $COL_SURVEY_COMPLETE_DATE TEXT, $COL_Q1 VARCHAR(256), " +
                    "$COL_A1 INTEGER, $COL_Q2 VARCHAR(256), $COL_A2 INTEGER, $COL_Q3 VARCHAR(256), $COL_A3 INTEGER, " +
                    "$COL_Q4 VARCHAR(256), $COL_A4 INTEGER, $COL_Q5 VARCHAR(256), $COL_A5 INTEGER, " +
                    "$COL_Q6 VARCHAR(256), $COL_A6 INTEGER, $COL_Q7 VARCHAR(256), $COL_A7 INTEGER, " +
                    "$COL_Q8 VARCHAR(256), $COL_A8 INTEGER, " +
                    "$COL_Q9 VARCHAR(256), $COL_A9 INTEGER, $COL_Q10 VARCHAR(256), $COL_A10 INTEGER, " +
                    "$COL_Q11 VARCHAR(256), $COL_A11 INTEGER, $COL_Q12 VARCHAR(256), $COL_A12 INTEGER, " +
                    "$COL_Q13 VARCHAR(256), $COL_A13 INTEGER, $COL_Q14 VARCHAR(256), $COL_A14 INTEGER, " +
                    "$COL_Q15 VARCHAR(256), $COL_A15 INTEGER, $COL_Q16 VARCHAR(256), $COL_A16 INTEGER, " +
                    "$COL_Q17 VARCHAR(256), $COL_A17 INTEGER, $COL_Q18 VARCHAR(256), $COL_A18 INTEGER, " +
                    "$COL_Q19 VARCHAR(256), $COL_A19 INTEGER, $COL_Q20 VARCHAR(256), $COL_A20 INTEGER)"

                db?.execSQL(createTable)
            }
        }

    fun insertData(username: String?,password: String?,email: String?){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_USERNAME,username)
        cv.put(COL_PASSWORD,password)
        cv.put(COL_EMAIL,email)
        //val nullColumnHack = ""
        val result = db.insert(TABLE_USERS, null, cv)
        if(result == (-1).toLong())
            Toast.makeText(context, "Failed to insert into DB",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success, user added to DB",Toast.LENGTH_SHORT).show()
       db.close()
    }


  /*  fun insertData(username: String, password: String, email: String){
        val db = this.writableDatabase
        val values = ContentValues()
        var args = listOf<String>(id)
        val id = db.rawQuery(("SELECT TOP 1 * FROM $TABLE_USERS ORDER BY $COL_ID DESC", args.toTypedArray())
        val result = db.rawQuery("SELECT TOP 1 * FROM $TABLE_USERS ORDER BY $COL_ID DESC", args.toTypedArray())

        values.put(COL_ID)
    }*/


    fun insertTestData() {
    val db = this.writableDatabase
    val cv = ContentValues()
    cv.put(COL_ID, "1")
    cv.put(COL_USERNAME, "Justin")
    cv.put(COL_PASSWORD, "11111")
    cv.put(COL_EMAIL, "test@gmail.com")
    cv.put(COL_AGE, "25")
    cv.put(COL_HEIGHT_FEET, "6")
    cv.put(COL_HEIGHT_INCH, "0")
    cv.put(COL_WEIGHT, "180")
    cv.put(COL_GENDER, "0")
    cv.put(COL_SURVEYS_COMPLETED, "0")
    cv.put(COL_LAST_COMPLETED_SURVEY, "0")
    cv.put(COL_ISPRIVACY, "0")
    cv.put(COL_ISPREMIUM, "0")
    //var result = db.insert(TABLE_USERS, null, cv)
    db.insert(TABLE_USERS, null, cv)
    cv.put(COL_ID, "2")
    cv.put(COL_USERNAME, "Dominic")
    cv.put(COL_PASSWORD, "22222")
    db.insert(TABLE_USERS, null, cv)
    cv.put(COL_ID, "3")
    cv.put(COL_USERNAME, "Cole")
    cv.put(COL_PASSWORD, "33333")
    db.insert(TABLE_USERS, null, cv)

    db.close()
}

    @SuppressLint("Range")
    /*fun readData(username: String, password: String) {
        val db = this.readableDatabase
        val args = listOf<String>(username, password)
        val result = db.rawQuery(
            "SELECT * FROM $TABLE_USERS WHERE $COL_USERNAME = ? AND $COL_PASSWORD = ?",
            args.toTypedArray()
        )
        if (result.moveToNext())
            Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()


        else
            Toast.makeText(context, "Incorrect Username and/or Password", Toast.LENGTH_SHORT).show()



    }*/
    fun checkUserNamePass(username: String, password: String) : Boolean {
        val db = this.readableDatabase
        var args = listOf<String>(username, password)
        var result = db.rawQuery(
            "SELECT * FROM $TABLE_USERS WHERE $COL_USERNAME = ? AND $COL_PASSWORD = ?",
            args.toTypedArray()
        )
        return if (result.moveToNext()) {
            Toast.makeText(context, "Login Successful $COL_ID", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(context, "Incorrect Username and/or Password", Toast.LENGTH_SHORT).show()
            false
        }


    }
    @SuppressLint("Range")
    fun getProfileData(username: String) : MutableList<User>
        {
        var list : MutableList<User> = ArrayList()
        var args = listOf<String>(username)
        val db = this.readableDatabase

            var result = db.rawQuery(
                "SELECT * FROM $TABLE_USERS WHERE $COL_USERNAME = ?", args.toTypedArray())
        if(result.moveToFirst())
            {
            do
                {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.userName = result.getString(result.getColumnIndex(COL_USERNAME))
                user.password = result.getString(result.getColumnIndex(COL_PASSWORD))
                user.email = result.getString(result.getColumnIndex(COL_EMAIL))
                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
                user.feet = result.getString(result.getColumnIndex(COL_HEIGHT_FEET)).toInt()
                user.inch = result.getString(result.getColumnIndex(COL_HEIGHT_INCH)).toInt()
                user.weight = result.getString(result.getColumnIndex(COL_WEIGHT)).toInt()
                user.gender = result.getString(result.getColumnIndex(COL_GENDER)).toInt()
                user.completedSurvey = result.getString(result.getColumnIndex(
                    COL_LAST_COMPLETED_SURVEY)).toInt()
                user.lastSurvey = result.getString(result.getColumnIndex(COL_LAST_COMPLETED_SURVEY))
                user.privacy = result.getString(result.getColumnIndex(COL_ISPRIVACY)).toInt()
                user.premium = result.getString(result.getColumnIndex(COL_ISPREMIUM)).toInt()
                list.add(user)
                }while (result.moveToNext())
            }
            result.close()
            db.close()
            return list


        }
}
/*
    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_USERS, "$COL_ID=?", arrayOf(1.toString()))

        db.close()
    }

    @SuppressLint("Range")
    fun updateData() {
        val db = this.writableDatabase
        val query = "Select * from $TABLE_USERS"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var cv = ContentValues()
                cv.put(COL_PASSWORD,result.getInt(result.getColumnIndex(COL_PASSWORD)+1))
                db.update(TABLE_USERS, cv,"$COL_ID=? AND $COL_USERNAME=?",
                arrayOf(result.getString(result.getColumnIndex(COL_ID)),
                result.getString(result.getColumnIndex(COL_USERNAME)))
                )
            }while (result.moveToNext())
        }
        result.close()
        db.close()
    }
*/