package com.example.myandroidapp.repository

import com.example.myandroidapp.data.ReservationDao
import com.example.myandroidapp.model.Reservation
import kotlinx.coroutines.flow.Flow

class ReservationRepository(private val reservationDao: ReservationDao) {
    val reservations: Flow<List<Reservation>> = reservationDao.getAll()
    fun reservationsByCar(carId: Long): Flow<List<Reservation>> = reservationDao.getByCar(carId)

    suspend fun addReservation(reservation: Reservation): Long = reservationDao.insert(reservation)
    suspend fun updateReservation(reservation: Reservation) = reservationDao.update(reservation)
    suspend fun deleteReservation(reservation: Reservation) = reservationDao.delete(reservation)
}
