package com.mycam.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.kotlin.query.RealmResults

class NoteAdapter(private val context: Context, private val dataSet: RealmResults<Note>) :
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
        val view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note: Note = dataSet[position]
        holder.title.text = note.title
        holder.description.text = note.description
        holder.timeCreated.text = note.createdTime.toString()
    }

    override fun getItemCount() = dataSet.size
}