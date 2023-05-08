package com.doce.cactus.saba.jetnote.data

import androidx.room.*
import com.doce.cactus.saba.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM notes where id =:id")
    suspend fun getNoteById(id: String): Note

    @Query("SELECT * FROM notes")
    fun getNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM notes")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(note:Note)

}
