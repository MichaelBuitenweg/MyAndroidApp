package com.example.myandroidapp.repository

import com.example.myandroidapp.data.CarDao
import com.example.myandroidapp.model.Car
import kotlinx.coroutines.flow.Flow

class CarRepository(private val carDao: CarDao) {
    val cars: Flow<List<Car>> = carDao.getAll()

    suspend fun addCar(car: Car): Result<Long> = try {
        val id = carDao.insert(car)
        Result.success(id)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun deleteCar(car: Car) = carDao.delete(car)
    suspend fun colorExists(color: String) = carDao.countByColor(color) > 0
}
