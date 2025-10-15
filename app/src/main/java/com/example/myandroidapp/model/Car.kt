package com.example.myandroidapp.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cars",
    indices = [Index(value = ["color"], unique = true)]
)
data class Car(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val model: String,
    val licenseNumber: String,
    val color: String // Hex color string (#RRGGBB)
)
