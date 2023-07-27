package com.mycam.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView
            val description: TextView
            val timeCreated: TextView

            init {
                title = view.findViewById(R.id.title)
                description = view.findViewById(R.id.description)
                timeCreated = view.findViewById(R.id.timeCreated)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position]
        holder.description.text = dataSet[position]
        holder.timeCreated.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}