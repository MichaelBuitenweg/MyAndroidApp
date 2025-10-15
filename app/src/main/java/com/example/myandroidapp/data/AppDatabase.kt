package com.example.myandroidapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myandroidapp.model.Car
import com.example.myandroidapp.model.Reservation

@Database(
    entities = [Car::class, Reservation::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
    abstract fun reservationDao(): ReservationDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "myandroidapp_database"
                )
                    .fallbackToDestructiveMigration() // TODO: Replace with proper migrations in production
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}