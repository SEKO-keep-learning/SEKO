package com.example.seko


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class content_index : AppCompatActivity() {

//    private lateinit var dbref : DatabaseReference
//    private lateinit var userRecyclerView: RecyclerView
//    private lateinit var topicsArrayList: ArrayList<index>
    private val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_index)

        val intent = getIntent()
        val value = intent.getStringExtra("language")
        Toast.makeText(this, "$value", Toast.LENGTH_LONG).show()

//        if (value == "cpl") {
//            db.collection("C").get()
//                .addOnSuccessListener { collection ->
//                    val documents = collection.documents
//                    for (document in documents) {
//                        val topics = document?.getString("Topics")
//
//
//                        Toast.makeText(this, "$topics", Toast.LENGTH_LONG).show()
//                      }
//                } .addOnFailureListener { exception ->
//                    // Handle any errors
//                }
//        } else {
//            Toast.makeText(this, "Not working", Toast.LENGTH_LONG).show()
//        }


    }
}