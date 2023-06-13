package com.example.seko

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import java.util.jar.Attributes.Name

class content_Main : AppCompatActivity() {
    private var textViewUser : TextView ? = null
    private val navigationMenu : Item ? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)

        val android : CardView = findViewById(R.id.android)
        val java : CardView = findViewById(R.id.java)
        val cpp : CardView = findViewById(R.id.cpp)
        val cpl : LinearLayout = findViewById(R.id.cpl)
        cpl.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "cpl")
            startActivity(intent)
        }
        cpp.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "cpp")
            startActivity(intent)
        }
        java.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "java")
            startActivity(intent)
        }
        android.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "android")
            startActivity(intent)
        }


        val intent = getIntent()
        val value = intent.getStringExtra("username")
        val textViewUser = findViewById<TextView>(R.id.textViewUser)
        textViewUser.setText("Hello ${value}")


    }
}