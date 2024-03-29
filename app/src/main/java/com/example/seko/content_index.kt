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
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class content_index : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var TopicsArrayList : ArrayList<index>
    private lateinit var database : FirebaseFirestore
    private lateinit var myAdapter: MyAdapter
    private var textViewCourse : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_index)

        var textViewCourse : TextView = findViewById(R.id.textViewCourse)
        val backButton : ImageView = findViewById(R.id.backButton)

        backButton.setOnClickListener{
           super.onBackPressed()
        }
         val intent = getIntent()
         val value = intent.getStringExtra("language")
        if(value == "cpl"){
            textViewCourse.setText("Introduction to C")
        recyclerView = findViewById(R.id.indexView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        TopicsArrayList = arrayListOf()
        myAdapter = MyAdapter(TopicsArrayList)
        recyclerView.adapter = myAdapter

        database = FirebaseFirestore.getInstance()
        database.collection("C").
            orderBy("Id", Query.Direction.ASCENDING).addSnapshotListener(object : EventListener<QuerySnapshot>{
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

        if(value == "python"){
            textViewCourse.setText("Introduction to Python")
            recyclerView = findViewById(R.id.indexView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)

            TopicsArrayList = arrayListOf()

            var myAdapter = MyAdapter(TopicsArrayList)
            recyclerView.adapter = myAdapter


            database = FirebaseFirestore.getInstance()
            database.collection("Python").
            orderBy("Id", Query.Direction.ASCENDING).addSnapshotListener(object : EventListener<QuerySnapshot>{
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


            })
            myAdapter.setOnItemClickListner(object : MyAdapter.onItemClickListner{
                override fun onItemClick(position: Int) {
                    if(position == 11){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Introduction")
                        startActivity(intent)
                    }
                    if(position == 0){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Expressions and Operator")
                        startActivity(intent)
                    }
                    if(position == 1){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Variables")
                        startActivity(intent)
                    }

                    if(position == 2){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Identifiers")
                        startActivity(intent)
                    }
                    if(position == 3){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Assignment Operators")
                        startActivity(intent)
                    }
                    if(position == 4){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Types Values and Expressions")
                        startActivity(intent)
                    }
                    if(position == 5){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Introduction to Objects and Methods")
                        startActivity(intent)
                    }
                    if(position == 6){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Conditional Statement")
                        startActivity(intent)
                    }
                    if(position == 7){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Numeric Data Types")
                        startActivity(intent)
                    }
                    if(position == 8){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Reading Strings from the Console")
                        startActivity(intent)
                    }
                    if(position == 9){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Strings and Characters")
                        startActivity(intent)
                    }
                    if(position == 10){
                        val intent = Intent(this@content_index, content_layout::class.java)
                        val context = intent.putExtra("python", "Flow Control Statement")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this@content_index,"Content not updated yet",Toast.LENGTH_LONG).show()
                    }
                }

            })
        }


        if(value == "android"){
            textViewCourse.setText("Introduction to Python")
            val intent = Intent(this, content_layout::class.java)
            startActivity(intent)
        }




    }
}