package com.example.seko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgetPassword : AppCompatActivity() {
    private var ForgetE : EditText ? = null

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        ForgetE = findViewById(R.id.ForgetE)
        val forgetBtn : Button = findViewById(R.id.forgetBtn)

        auth = FirebaseAuth.getInstance()

        forgetBtn.setOnClickListener{
            val email = ForgetE?.text.toString()
            auth.sendPasswordResetEmail(email)
                .addOnSuccessListener {

                    Toast.makeText(this, "Please check you email", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }.addOnFailureListener{
                    Toast.makeText(this, it.toString(),Toast.LENGTH_LONG).show()
                }
        }

    }
}