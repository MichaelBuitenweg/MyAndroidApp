package com.example.myandroidapp.data

import androidx.room.*
import com.example.myandroidapp.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Query("SELECT * FROM cars ORDER BY name")
    fun getAll(): Flow<List<Car>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(car: Car): Long

    @Delete
    suspend fun delete(car: Car)

    @Query("SELECT COUNT(*) FROM cars WHERE color = :color")
    suspend fun countByColor(color: String): Int
}
