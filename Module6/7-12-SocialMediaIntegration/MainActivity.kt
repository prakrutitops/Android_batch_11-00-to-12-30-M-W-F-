package com.example.googleplusintegrationex

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.googleplusintegrationex.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status


class MainActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    private lateinit var binding: ActivityMainBinding
    lateinit var mProgressDialog:ProgressDialog
    lateinit var apiClient: GoogleApiClient
    private val RC_SIGN_IN = 7


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mProgressDialog = ProgressDialog(this)

        var gso:GoogleSignInOptions=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        apiClient=GoogleApiClient.Builder(this)
            .enableAutoManage(this,this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        binding.btnSignIn.setSize(SignInButton.SIZE_STANDARD)
        binding.btnSignIn.setScopes(gso.getScopeArray())

        binding.btnSignIn.setOnClickListener {

                var i:Intent = Auth.GoogleSignInApi.getSignInIntent(apiClient)
                 startActivityForResult(i, RC_SIGN_IN)

        }
        binding.btnSignOut.setOnClickListener {
            Auth.GoogleSignInApi.signOut(apiClient).setResultCallback(
                object : ResultCallback<Status?>
                {


                    override fun onResult(p0: Status) {
                        updateUI(false)
                    }
                })
        }
        binding.btnRevokeAccess.setOnClickListener {

            Auth.GoogleSignInApi.signOut(apiClient).setResultCallback(
                object : ResultCallback<Status?>
                {


                    override fun onResult(p0: Status) {
                        updateUI(false)
                    }
                })
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_SIGN_IN)
        {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            handleSignInResult(result)
        }

    }

    private fun handleSignInResult(result: GoogleSignInResult?)
    {
            if(result!!.isSuccess)
            {
                val acct = result.signInAccount

                val personName = acct!!.displayName
                val personPhotoUrl = acct!!.photoUrl.toString()
                val email = acct!!.email

                binding.txtName.setText(personName)
                binding.txtEmail.setText(email)

                Glide.with(applicationContext)
                    .load(personPhotoUrl)
                    .into(binding.imgProfilePic)

                updateUI(true)
            }
            else
            {
                updateUI(false)
            }
    }

    private fun updateUI(isSignedIn: Boolean)
    {
        if (isSignedIn) {
            binding.btnSignIn.setVisibility(View.GONE)
            binding.btnSignOut.setVisibility(View.VISIBLE)
            binding.btnRevokeAccess.setVisibility(View.VISIBLE)
            binding.llProfile.setVisibility(View.VISIBLE)
        } else {
            binding.btnSignIn.setVisibility(View.VISIBLE)
            binding.btnSignOut.setVisibility(View.GONE)
            binding.btnRevokeAccess.setVisibility(View.GONE)
            binding.llProfile.setVisibility(View.GONE)

        }
    }

    override fun onStart() {
        super.onStart()
        val opr = Auth.GoogleSignInApi.silentSignIn(apiClient)
        if (opr.isDone) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d("TAG", "Got cached sign-in")
            val result = opr.get()
            handleSignInResult(result)
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog()
            opr.setResultCallback(object : ResultCallback<GoogleSignInResult?> {


                override fun onResult(p0: GoogleSignInResult) {
                    hideProgressDialog()
                    handleSignInResult(p0)
                }
            })
        }

    }

    override fun onConnectionFailed(p0: ConnectionResult)
    {
        Log.d("Connection Fail", "onConnectionFailed:" + p0)
    }
    fun showProgressDialog() {
        if (mProgressDialog == null)
        {

            mProgressDialog.setMessage(getString(R.string.loading))
            mProgressDialog.setIndeterminate(true)
        }

        mProgressDialog.show()
    }

    fun hideProgressDialog()
    {
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.hide()
        }
    }


}