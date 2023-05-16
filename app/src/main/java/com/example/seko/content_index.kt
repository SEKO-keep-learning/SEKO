package com.example.seko


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class content_index : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var TopicsArrayList : ArrayList<index>
    private lateinit var database : FirebaseFirestore
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_index)

        val backButton : ImageView = findViewById(R.id.backButton)


        backButton.setOnClickListener{
            val intent = Intent(this, content_Main::class.java)
            startActivity(intent)
            finish()

        }

         val intent = getIntent()
         val value = intent.getStringExtra("language")
        if(value == "cpl"){
        recyclerView = findViewById(R.id.indexView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        TopicsArrayList = arrayListOf()
        myAdapter = MyAdapter(TopicsArrayList)
        recyclerView.adapter = myAdapter

        database = FirebaseFirestore.getInstance()
        database.collection("C").
        addSnapshotListener(object : EventListener<QuerySnapshot>{
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error!=null){
                    Log.e("Firestore Error",error.message.toString())
                    return
                }
                for(dc : DocumentChange in value?.documentChanges!!){
                    if(dc.type==DocumentChange.Type.ADDED){
                        TopicsArrayList.add(dc.document.toObject(index::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }

        })}
        if(value == "cpp"){
            Toast.makeText(this,"c++ content will be available soon", Toast.LENGTH_LONG).show()
        }

        if(value == "java"){
            Toast.makeText(this,"Java content will be available soon", Toast.LENGTH_LONG).show()
        }

        if(value == "android"){
            Toast.makeText(this,"Android content will be available soon", Toast.LENGTH_LONG).show()
        }




    }
}