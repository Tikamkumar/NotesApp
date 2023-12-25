package com.tikamkumar.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.tikamkumar.notesapp.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db: NoteDatabaseHelper
    private var note_id: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        note_id = intent.getIntExtra("note_id", -1)
        if(note_id == -1) {
            finish()
            return
        }

        val note = db.getNoteById(note_id)

        binding.updateTitleEditText.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener {
            val title = binding.updateTitleEditText.text.toString()
            val content = binding.updateContentEditText.text.toString()
            db.updateNote(Note(note_id, title, content))
            finish()
            Toast.makeText(this, "Changes Saved..", Toast.LENGTH_SHORT).show()
        }
    }
}