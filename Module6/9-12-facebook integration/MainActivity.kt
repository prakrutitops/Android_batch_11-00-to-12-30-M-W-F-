package com.example.fbex1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import kotlin.math.log


class MainActivity : AppCompatActivity()
{
    var loginButton: LoginButton? = null
    var callbackManager: CallbackManager? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_main)

        loginButton=findViewById(R.id.login_button)
        callbackManager=CallbackManager.Factory.create()

        loginButton.registerCallback(callbackManager,object :FacebookCallback<LoginResult>{
            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onError(error: FacebookException) {
                TODO("Not yet implemented")
            }

            override fun onSuccess(result: LoginResult) {
                TODO("Not yet implemented")
            }
        })

    }
}