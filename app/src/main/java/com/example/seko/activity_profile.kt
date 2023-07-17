package com.example.seko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class activity_profile : AppCompatActivity() {
    //private var nameTextView : TextView ? = null
    private val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val back_home : TextView = findViewById(R.id.back_home)
        val profileEmail : TextView = findViewById(R.id.profileEmail)
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val dob : TextView = findViewById(R.id.dob)
        val profileAddress : TextView = findViewById(R.id.profileAddress)
        val profilePhone : TextView = findViewById(R.id.ProfilePhone)

        val intent = getIntent()
        val value = intent.getStringExtra("username")
        nameTextView.setText("$value")

        db.collection("User").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("name") == value) {
                        val email = document.getString("email")
                        val phoneNo = document.getString("Phone")
                        val Dob = document.getString("DOB")
                        val profileAdd = document.getString("address")
                        profileEmail.setText("$email")
                        profilePhone.setText("$phoneNo")
                        dob.setText("$Dob")
                        profileAddress.setText("$profileAdd")


                    }
                }
            }

        back_home.setOnClickListener{
            super.onBackPressed()
        }

    }
}