package com.example.seko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.util.jar.Attributes.Name

class content_Main : AppCompatActivity() {
    private var textViewUser : TextView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_main)

        val intent = getIntent()
        val value = intent.getStringExtra("username")
        val textViewUser = findViewById<TextView>(R.id.textViewUser)
        textViewUser.setText("Hello ${value}")

    }
}