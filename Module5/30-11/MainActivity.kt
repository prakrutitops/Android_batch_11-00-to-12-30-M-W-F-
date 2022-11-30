package com.example.otpverify

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity()
{

    lateinit var edtPhone: EditText
    lateinit var edtOtp:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var verificationid:String
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // auth = Firebase.auth
        auth = FirebaseAuth.getInstance()

        edtPhone = findViewById(R.id.idEdtPhoneNumber)
        edtOtp = findViewById(R.id.idEdtOtp)
        btn2 = findViewById(R.id.idBtnVerify)
        btn1 = findViewById(R.id.idBtnGetOtp)


        btn1.setOnClickListener {

            if (TextUtils.isEmpty(edtPhone.text.toString()))
            {

                Toast.makeText(this@MainActivity, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {

                val phone: String = edtPhone.text.toString()
                sendVerificationCode(phone)
            }


        }
        btn2.setOnClickListener {

            if (TextUtils.isEmpty(edtPhone.text.toString()))
            {

                Toast.makeText(this@MainActivity, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {

                val otp: String = edtOtp.text.toString()
                verifycode(otp)
            }




        }



    }

    private fun verifycode(otp: String)
    {
        val credential = PhoneAuthProvider.getCredential(verificationid, otp)
        signinwithcredential(credential)
    }

    private fun signinwithcredential(credential: PhoneAuthCredential)
    {

            auth.signInWithCredential(credential)

                .addOnCompleteListener()
                {
                            if(it.isSuccessful)
                            {
                                var i = Intent(this,MainActivity2::class.java)
                                startActivity(i)
                            }
                            else
                            {

                            }
                }
                .addOnFailureListener()
                {

                }

    }

    var mCallBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks()
    {
        override fun onVerificationCompleted(p0: PhoneAuthCredential)
        {
            var  code = p0.getSmsCode()
            if(code!=null)
            {
                edtOtp.setText(code)
            }
            else
            {
                Toast.makeText(applicationContext,"Error  ", Toast.LENGTH_LONG).show();

            }
        }

        override fun onVerificationFailed(p0: FirebaseException)
        {

        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken)
        {
            // super.onCodeSent(p0, p1)
            verificationid=p0
        }

    }
    private fun sendVerificationCode(phone: String)
    {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,60, TimeUnit.SECONDS,this,mCallBack)
    }


}