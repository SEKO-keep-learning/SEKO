package com.example.seko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.seko.databinding.ActivityMainBinding
import com.example.seko.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignupActivity : BaseActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {

            showProgressDialog(resources.getString(R.string.please_click_back_again_to_exit))
            val name = binding.nameRegister.text.toString()
            val email = binding.emailRegister.text.toString()
            val pass = binding.passwordRegister.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        firebaseAuth.currentUser?.sendEmailVerification()
                            ?.addOnSuccessListener {
                                Toast.makeText(this, "Please check you email for verification", Toast.LENGTH_LONG).show()

                                val user = hashMapOf(
                                    "name" to name,
                                    "email" to email,
                                    "password" to pass
                                )
                                db.collection("User")
                                    .add(user)
                                    .addOnSuccessListener { documentReference ->

                                        val intent = Intent(this, MainActivity::class.java)
                                        startActivity(intent)
                                        hideProgressDialog()
                                    }
                            }
                            ?.addOnFailureListener{
                                hideProgressDialog()
                                Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show()
                            }
                    } else {
                        hideProgressDialog()
                        showErrorSnackBar(it.exception.toString())
                    }
                }
            } else {
                hideProgressDialog()
                showErrorSnackBar("Empty Fields are not allowed")
            }

        }
        binding.btnSignin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}