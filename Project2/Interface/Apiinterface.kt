package com.example.firstapp

import com.example.firstapp.Model.Dashboard_Model
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("signup.php")
    fun registerdetail
    (
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("phone") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,

        ): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("pass") password: String?
        ):Call<RegisterModel>


    @get:GET("dashboard.php")
    val dashboard_view: Call<List<Dashboard_Model?>?>?


}