package com.example.seko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView

class app_bar_main : AppCompatActivity() {
    private lateinit var navigationQuiz : MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)

        var navigationQuiz : MenuItem = findViewById(R.id.navigationQuiz)
        onOptionsItemSelected(navigationQuiz)


    }

}