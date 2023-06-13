package com.example.seko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class webView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        //Insert webView item in activity
        val myWeb = findViewById<WebView>(R.id.webView)

        myWeb.apply {
            loadUrl( "https://onecompiler.com/c")
            settings.javaScriptEnabled = true
        }

    }
}