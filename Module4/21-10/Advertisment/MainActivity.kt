package com.example.advertismentex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class MainActivity : AppCompatActivity()
{
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)

        val adRequest: AdRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

    }
}