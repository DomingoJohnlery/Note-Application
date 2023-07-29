package com.mycam.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mycam.noteapp.databinding.ActivityEditBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmQuery
import io.realm.kotlin.query.RealmResults
import java.text.DateFormat

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private lateinit var config: RealmConfiguration
    private lateinit var realm: Realm
    private lateinit var title: String
    private lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        config = RealmConfiguration.create(schema = setOf(Note::class))
        realm = Realm.open(config)

        val noteData = intent.extras
        if (noteData != null){
            title = noteData.getString("title")!!
            description = noteData.getString("desc")!!
        }

        binding.btnEditNote.setOnClickListener {
            editNote()
            finish()
        }
    }

    private fun editNote() {
        realm.writeBlocking {
            val note: Note? = this.query<Note>("title == $0",title).first().find()
            //note?.title = title
            //note?.description = description
            //note?.createdTime = System.currentTimeMillis()
        }
        Toast.makeText(this,"Note Edited successfully!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}