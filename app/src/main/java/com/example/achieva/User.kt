package com.example.achieva

class User{

    var id: Int = 0
    var userName : String = ""
    var password: String = ""
    var email: String = ""
    var age: Int = 0
    var feet: Int = 0
    var inch: Int = 0
    var weight: Int = 0
    var gender: Int? = null
    var completedSurvey: Int = 0
    var lastSurvey: String = ""
    var privacy: Int = 0
    var premium: Int = 0



    constructor(name:String,age:Int){
        this.userName = userName
        this.password = password
        this.email = email
        this.age = age
        this.feet = feet
        this.inch = inch
        this.weight = weight
        this.gender = gender
        this.completedSurvey = completedSurvey
        this.lastSurvey = lastSurvey
        this.privacy = privacy
        this.premium = premium
    }

    constructor(){

    }
}