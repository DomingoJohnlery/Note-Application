package com.mycam.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycam.noteapp.databinding.ActivityNoteBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding
    private lateinit var config: RealmConfiguration
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        config = RealmConfiguration.create(schema = setOf(Note::class))
        realm = Realm.open(config)

        binding.btnSaveNote.setOnClickListener {
            writeNote()
            finish()
        }
    }

    private fun writeNote() {
        realm.writeBlocking {
            this.copyToRealm(Note().apply {
                title = binding.singleLine.text.toString()
                description = binding.multiLine.text.toString()
                createdTime = System.currentTimeMillis()
            })
        }
    }
}