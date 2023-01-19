package com.example.adminlogin

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterModel
{
    @Expose
    @SerializedName("firstname")
    var fname=""

    @Expose
    @SerializedName("lastname")
    var lname=""

    @Expose
    @SerializedName("phone")
    var mobile=""

    @Expose
    @SerializedName("email")
    var email=""

    @Expose
    @SerializedName("password")
    var password=""
}