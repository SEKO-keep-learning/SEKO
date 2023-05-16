package com.example.seko

import android.content.Intent
import com.example.seko.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.seko.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : BaseActivity() {

    private var email : EditText? = null
    private var pass : EditText? = null
    private val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth
    val dab = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val btnLogin : TextView = findViewById(R.id.btnLogin)
        val btSignUp : TextView = findViewById(R.id.btSignUp)
        email = findViewById(R.id.emailSignIn)
        pass = findViewById(R.id.passSignIn)

        btnLogin.setOnClickListener{
            signIn()
        }

        btSignUp.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signIn(){
        val et_email : String = email?.text.toString().trim{ it <= ' '}
        val et_pass : String = pass?.text.toString().trim{ it <= ' '}



        if (validate(et_email, et_pass)) {

            showProgressDialog(resources.getString(R.string.please_click_back_again_to_exit))
            auth.signInWithEmailAndPassword(et_email, et_pass)

                .addOnCompleteListener(this) { task ->


                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Sign in", "signInWithEmail:success")
                        val user = auth.currentUser
                        if (!user!!.isEmailVerified) {

                            hideProgressDialog()
                            Toast.makeText(this,"Please verify your account first", Toast.LENGTH_LONG).show()


                        }
                        else{
                            db.collection("User").get()
                                .addOnSuccessListener { collection ->
                                    val documents = collection.documents
                                    for (document in documents) {
                                        if(document.get("email") == et_email){
                                            val username = document.getString("name")
                                            val intent = Intent(this, content_Main::class.java)
                                            val Name = intent.putExtra("username", "$username")

                                            startActivity(intent)

                                            finish()
                                        }}
                                } .addOnFailureListener { exception ->
                                    // Handle any errors
                                }

                        }

                        // updateUI(user)
                        // readData()
                    } else {
                        // If sign in fails, display a message to the user.
                        hideProgressDialog()
                        Log.w("Sign in", "signInWithEmail:failure", task.exception)
                        showErrorSnackBar("Please enter the details properly or check Internet connection")
                        // updateUI(null)
                    }
                }
        }
        }

    private fun validate(et_email : String, et_pass : String):Boolean{
        return when{
            TextUtils.isEmpty(et_email) -> {
                showErrorSnackBar("Please enter proper username")
                false
            }
            TextUtils.isEmpty(et_pass) -> {
                showErrorSnackBar("Please enter proper password")
                false
            }
            else -> {
                true
            }
        }

    }
}





