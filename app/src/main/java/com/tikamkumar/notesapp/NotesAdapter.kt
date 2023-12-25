package com.tikamkumar.notesapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes: List<Note>, context: Context):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemVie: View): RecyclerView.ViewHolder(itemVie) {
        val titleTextView: TextView = itemVie.findViewById(R.id.titleTextView)
        val contentTextView = itemVie.findViewById<TextView>(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(newNotes : List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}