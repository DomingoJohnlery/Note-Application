package com.mycam.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycam.noteapp.databinding.ActivityNoteBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = RealmConfiguration.create(schema = setOf(Note::class))
        val realm: Realm = Realm.open(config)

        binding.btnSaveNote.setOnClickListener {
            realm.writeBlocking {
                copyToRealm(Note().apply {
                    title = binding.singleLine.text.toString()
                    description = binding.multiLine.text.toString()
                })
            }
            finish()
        }
    }
}