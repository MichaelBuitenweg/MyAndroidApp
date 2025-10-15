package com.example.myandroidapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myandroidapp.model.Car
import com.example.myandroidapp.repository.CarRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class CarUiState(
    val cars: List<Car> = emptyList(),
    val error: String? = null
)

class CarViewModel(private val repository: CarRepository) : ViewModel() {
    val uiState: StateFlow<CarUiState> = repository.cars
        .map { CarUiState(cars = it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), CarUiState())

    fun addCar(name: String, model: String, license: String, color: String, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            if (repository.colorExists(color)) {
                onResult(false, "Color already in use")
                return@launch
            }
            val result = repository.addCar(Car(name = name, model = model, licenseNumber = license, color = color))
            onResult(result.isSuccess, result.exceptionOrNull()?.message)
        }
    }

    fun deleteCar(car: Car) {
        viewModelScope.launch { repository.deleteCar(car) }
    }

    class Factory(private val repository: CarRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CarViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CarViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
