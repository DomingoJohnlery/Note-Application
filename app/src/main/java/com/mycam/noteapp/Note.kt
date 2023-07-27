package com.mycam.noteapp

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Note : RealmObject{
    @PrimaryKey
    var title: String = ""
    var description: String = ""
}