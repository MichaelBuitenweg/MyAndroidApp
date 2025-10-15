package com.example.myandroidapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "reservations",
    foreignKeys = [
        ForeignKey(
            entity = Car::class,
            parentColumns = ["id"],
            childColumns = ["carId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("carId")]
)
data class Reservation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val carId: Long,
    val startDate: Long, // store as epoch millis
    val endDate: Long
)
