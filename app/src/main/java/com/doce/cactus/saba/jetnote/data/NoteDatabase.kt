package com.doce.cactus.saba.jetnote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.doce.cactus.saba.jetnote.model.Note
import com.doce.cactus.saba.jetnote.utils.DateConverter
import com.doce.cactus.saba.jetnote.utils.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}