package com.example.myandroidapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myandroidapp.model.Reservation
import com.example.myandroidapp.repository.ReservationRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ReservationUiState(
    val reservations: List<Reservation> = emptyList()
)

class ReservationViewModel(private val repository: ReservationRepository) : ViewModel() {
    val uiState: StateFlow<ReservationUiState> = repository.reservations
        .map { ReservationUiState(reservations = it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), ReservationUiState())

    fun addReservation(carId: Long, start: Long, end: Long) {
        if (end < start) return
        viewModelScope.launch {
            repository.addReservation(Reservation(carId = carId, startDate = start, endDate = end))
        }
    }

    fun updateReservation(reservation: Reservation) {
        if (reservation.endDate < reservation.startDate) return
        viewModelScope.launch { repository.updateReservation(reservation) }
    }

    fun deleteReservation(reservation: Reservation) {
        viewModelScope.launch { repository.deleteReservation(reservation) }
    }

    class Factory(private val repository: ReservationRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ReservationViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ReservationViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
