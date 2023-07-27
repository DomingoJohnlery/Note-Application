package com.mycam.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycam.noteapp.databinding.ActivityMainBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val config = RealmConfiguration.create(schema = setOf(Note::class))
        val realm: Realm = Realm.open(config)

        val notes: RealmResults<Note> = realm.query<Note>().find()

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this,NoteActivity::class.java))
        }
    }
}