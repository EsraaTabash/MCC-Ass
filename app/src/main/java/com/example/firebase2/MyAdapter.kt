package com.example.firebase2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class MyAdapter (var activity: Activity, var data :ArrayList<Model>)
    : RecyclerView.Adapter <MyAdapter.myViewHolder>() {

    class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val name=itemView.tv_noteName
        val content=itemView.tv_noteContent
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
            val root=LayoutInflater.from(activity).inflate(R.layout.note_item,parent,false)
            return myViewHolder(root)
        }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.name.text=data[position].name
        holder.content.text=data[position].content
    }
    override fun getItemCount(): Int {
        return data.size
    }


}
