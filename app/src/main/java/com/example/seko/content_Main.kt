package com.example.seko

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import java.util.jar.Attributes.Name

class content_Main : AppCompatActivity() {
    private val profileCircleImageView : ImageView ? = null
    private var textViewUser : TextView ? = null
    private val navigationMenu : Item ? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)

        val profileCircleImageView : ImageView =  findViewById(R.id.profileCircleImageView)
        val pythonL : LinearLayout = findViewById(R.id.android)
        val java : LinearLayout = findViewById(R.id.java)
        val cpp : LinearLayout = findViewById(R.id.cpp)
        val cpl : LinearLayout = findViewById(R.id.cpl)

        val intent = getIntent()
        val value = intent.getStringExtra("username")
        val textViewUser = findViewById<TextView>(R.id.textViewUser)
        textViewUser.setText("Hello ${value}")

        profileCircleImageView.setOnClickListener{
            val intent = Intent(this, activity_profile::class.java)
            val Name = intent.putExtra("username", "$value")
            startActivity(intent)
        }
        cpl.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "cpl")
            startActivity(intent)
        }
        cpp.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "python")
            startActivity(intent)
        }
        java.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "java")
            startActivity(intent)
        }
        pythonL.setOnClickListener{
            val intent = Intent(this, content_index::class.java)
            val language = intent.putExtra("language", "python")
            startActivity(intent)
        }





    }
}