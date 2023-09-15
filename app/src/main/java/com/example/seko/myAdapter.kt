package com.example.seko

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val topicsList: ArrayList<index>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var mListner: onItemClickListner
    interface onItemClickListner{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListner(listner: onItemClickListner){
        mListner = listner
    }
    class MyViewHolder(itemView: View, listner: onItemClickListner) : RecyclerView.ViewHolder(itemView){
        val Topics : TextView = itemView.findViewById(R.id.topics)
        val num : TextView = itemView.findViewById(R.id.num)

        init{
               itemView.setOnClickListener {
                   listner.onItemClick(adapterPosition)
               }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.index, parent, false)
        return MyViewHolder(itemView, mListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = topicsList[position]
        holder.Topics.text = currentItem.Topics
        holder.num.text = currentItem.Id

        
    }

    override fun getItemCount(): Int {
       return topicsList.size
    }

}