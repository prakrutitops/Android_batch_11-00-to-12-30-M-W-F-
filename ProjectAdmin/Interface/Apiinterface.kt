package com.example.adminlogin

import com.example.firstapp.Model.Dashboard_Model
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{


    @FormUrlEncoded
    @POST("adminlogin.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("pass") password: String?
        ):Call<RegisterModel>


    @get:GET("dashboard.php")
    val dashboard_view: Call<List<Dashboard_Model?>?>?


    @get:GET("diwaliupload.php")
    val diwaliupload: Call<List<Dashboard_Model?>?>?




}