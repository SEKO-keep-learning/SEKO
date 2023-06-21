package com.example.seko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val topicsList: ArrayList<index>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Topics : TextView = itemView.findViewById(R.id.topics)
        val num : TextView = itemView.findViewById(R.id.num)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.index, parent, false)
        return MyViewHolder(itemView)
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