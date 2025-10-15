package com.example.myandroidapp.ui

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.myandroidapp.databinding.DialogReservationBinding
import com.example.myandroidapp.model.Car
import com.example.myandroidapp.model.Reservation
import com.example.myandroidapp.viewmodel.CarViewModel
import com.example.myandroidapp.viewmodel.ReservationViewModel
import java.util.*

class ReservationDialog(private val reservation: Reservation?, private val dayStart: Long?) : DialogFragment() {
    private val carViewModel: CarViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).carViewModelFactory }
    private val reservationViewModel: ReservationViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).reservationViewModelFactory }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogReservationBinding.inflate(LayoutInflater.from(context))

        var startDate = reservation?.startDate ?: dayStart ?: System.currentTimeMillis()
        var endDate = reservation?.endDate ?: startDate

        // Populate cars spinner
        val cars = (carViewModel.uiState.value.cars)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, cars.map { it.name })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCar.adapter = adapter
        if (reservation != null) {
            val idx = cars.indexOfFirst { it.id == reservation.carId }
            if (idx >= 0) binding.spinnerCar.setSelection(idx)
        }

        fun pickDate(isStart: Boolean) {
            val cal = Calendar.getInstance().apply { timeInMillis = if (isStart) startDate else endDate }
            DatePickerDialog(requireContext(), { _, y, m, d ->
                cal.set(Calendar.YEAR, y); cal.set(Calendar.MONTH, m); cal.set(Calendar.DAY_OF_MONTH, d)
                if (isStart) startDate = cal.timeInMillis else endDate = cal.timeInMillis
                binding.textStartDate.text = Date(startDate).toString()
                binding.textEndDate.text = Date(endDate).toString()
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.textStartDate.text = Date(startDate).toString()
        binding.textEndDate.text = Date(endDate).toString()
        binding.buttonPickStart.setOnClickListener { pickDate(true) }
        binding.buttonPickEnd.setOnClickListener { pickDate(false) }

        return AlertDialog.Builder(requireContext())
            .setTitle(if (reservation == null) "New Reservation" else "Edit Reservation")
            .setView(binding.root)
            .setPositiveButton("Save") { _, _ ->
                val car = cars.getOrNull(binding.spinnerCar.selectedItemPosition) ?: return@setPositiveButton
                if (reservation == null) {
                    reservationViewModel.addReservation(car.id, startDate, endDate)
                } else {
                    reservationViewModel.updateReservation(reservation.copy(carId = car.id, startDate = startDate, endDate = endDate))
                }
            }
            .setNegativeButton("Cancel", null)
            .apply {
                if (reservation != null) {
                    setNeutralButton("Delete") { _, _ ->
                        reservationViewModel.deleteReservation(reservation)
                    }
                }
            }
            .create()
    }
}
