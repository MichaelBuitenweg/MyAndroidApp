package com.example.myandroidapp.data

import androidx.room.*
import com.example.myandroidapp.model.Reservation
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservations ORDER BY startDate")
    fun getAll(): Flow<List<Reservation>>

    @Query("SELECT * FROM reservations WHERE carId = :carId ORDER BY startDate")
    fun getByCar(carId: Long): Flow<List<Reservation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reservation: Reservation): Long

    @Update
    suspend fun update(reservation: Reservation)

    @Delete
    suspend fun delete(reservation: Reservation)
}
