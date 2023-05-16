package com.example.seko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import java.util.jar.Attributes.Name

class content_Main : AppCompatActivity() {
    private var textViewUser : TextView ? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)

        val cpl : CardView = findViewById(R.id.cpl)
        cpl.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "cpl")
            startActivity(intent)
        }

        val intent = getIntent()
        val value = intent.getStringExtra("username")
        val textViewUser = findViewById<TextView>(R.id.textViewUser)
        textViewUser.setText("Hello ${value}")


    }
}