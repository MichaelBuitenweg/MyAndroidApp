package com.example.myandroidapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myandroidapp.model.Entity

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: Entity)

    @Query("SELECT * FROM entity_table WHERE id = :id")
    suspend fun getEntityById(id: Int): Entity?

    @Query("SELECT * FROM entity_table")
    suspend fun getAllEntities(): List<Entity>

    @Query("DELETE FROM entity_table WHERE id = :id")
    suspend fun deleteEntityById(id: Int)
}