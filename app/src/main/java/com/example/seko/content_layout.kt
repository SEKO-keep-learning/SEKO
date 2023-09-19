package com.example.seko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class content_layout : AppCompatActivity() {

    private var Content : TextView? = null
    private var topic : TextView? = null
    private var language_head : TextView? = null
    private val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth
    val dab = FirebaseFirestore.getInstance()

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_layout)

        var Content : TextView = findViewById(R.id.para)
        var topic : TextView = findViewById(R.id.Topic)
        var language_head : TextView = findViewById(R.id.language_head)

         language_head.setText("Python")
        val intent = getIntent()
        val value = intent.getStringExtra("python")
        if(value == "Introduction"){
            topic.setText("$value")
            db.collection("Python").get()
                .addOnSuccessListener { collection ->
                    val documents = collection.documents
                    for (document in documents) {
                        if (document.get("Topics") == "Introduction") {


                            val content = document.getString("Content")
                            val content1 = document.getString("Content1")
                            val content2 = document.getString("Content2")
                            val content3 = document.getString("Content3")
//                            val content4 = document.getString("Content4")
                            val content5 = document.getString("Content5")
                            Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content5")

                        }
                        }
                    }
        }
    if(value == "Variables"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Variables") {


                        val content = document.getString("Content")
//                        val content1 = document.getString("Content1")
//                        val content2 = document.getString("Content2")
//                        val content3 = document.getString("Content3")
//                        val content4 = document.getString("Content4")
//                        val content5 = document.getString("Content5")
                        Content.setText("$content")

                    }
                }
            }
    }
    if(value == "Identifiers"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Identifiers") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
                        val content5 = document.getString("Content5")
                        val content6 = document.getString("Content6")
                        val content7 = document.getString("Content7")
                        val content8 = document.getString("Content8")
                        val content9 = document.getString("Content9")
                        val content10 = document.getString("Content10")
                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4\n\n$content5\n\n1)$content11\n\n" +
                                "$content6\n\n$content7\n\n$content8\n\n$content8\n\n$content9\n\n$content10")

                    }
                }
            }
    }
    if(value == "Expressions and Operator"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Expressions and Operator") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
//                        val content5 = document.getString("Content5")
//                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4")

                    }
                }
            }
    }
    if(value == "Assignment Operators"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Expressions and Operator") {


                        val content = document.getString("Content")
//                        val content1 = document.getString("Content1")
//                        val content2 = document.getString("Content2")
//                        val content3 = document.getString("Content3")
//                        val content4 = document.getString("Content4")
//                        val content5 = document.getString("Content5")
//                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content")

                    }
                }
            }
    }
    if(value == "Types Values and Expressions"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Types Values and Expressions") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
//                        val content5 = document.getString("Content5")
//                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4")

                    }
                }
            }
    }
    if(value == "Introduction to Objects and Methods"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Introduction to Objects and Methods") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
//                        val content4 = document.getString("Content4")
//                        val content5 = document.getString("Content5")
//                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3")

                    }
                }
            }
    }
    if(value == "Conditional Statement"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Introduction to Objects and Methods") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
                        val content5 = document.getString("Content5")
                        val content6 = document.getString("Content6")
                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4\n\n$content5\n\n$content6\n\n$content7")

                    }
                }
            }
    }
    if(value == "Numeric Data Types"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Numeric Data Types") {


                        val content = document.getString("Content")
//                        val content1 = document.getString("Content1")
//                        val content2 = document.getString("Content2")
//                        val content3 = document.getString("Content3")
//                        val content4 = document.getString("Content4")
//                        val content5 = document.getString("Content5")
//                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content")

                    }
                }
            }
    }

    if(value == "Reading Strings from the Console"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Reading Strings from the Console") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
                        val content5 = document.getString("Content5")
                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4\n\n$content5\n\n$content6")

                    }
                }
            }
    }
    if(value == "Strings and Characters"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Strings and Characters") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
                        val content5 = document.getString("Content5")
                        val content6 = document.getString("Content6")
                        val content7 = document.getString("Content7")
                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4\n\n$content5\n\n$content6\n\n$content7" +
                                "\n\n$content8")

                    }
                }
            }
    }
    if(value == "Flow Control Statement"){

        topic.setText("$value")
        db.collection("Python").get()
            .addOnSuccessListener { collection ->
                val documents = collection.documents
                for (document in documents) {
                    if (document.get("Topics") == "Flow Control Statement") {


                        val content = document.getString("Content")
                        val content1 = document.getString("Content1")
                        val content2 = document.getString("Content2")
                        val content3 = document.getString("Content3")
                        val content4 = document.getString("Content4")
                        val content5 = document.getString("Content5")
//                        val content6 = document.getString("Content6")
//                        val content7 = document.getString("Content7")
//                        val content8 = document.getString("Content8")
//                        val content9 = document.getString("Content9")
//                        val content10 = document.getString("Content10")
//                        val content11 = document.getString("Content11")
                        Content.setText("$content\n\n$content1\n\n$content2\n\n$content3\n\n$content4\n\n$content5")

                    }
                }
            }
    }
    }

}