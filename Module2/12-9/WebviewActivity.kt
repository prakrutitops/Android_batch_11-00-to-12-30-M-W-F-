package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebviewActivity : AppCompatActivity()
{
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webView=findViewById(R.id.web)
        webView.loadUrl("https://www.javatpoint.com/java-tutorial")

    }
}