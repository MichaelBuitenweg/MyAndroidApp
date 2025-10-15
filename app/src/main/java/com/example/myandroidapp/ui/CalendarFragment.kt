package com.example.myandroidapp.ui

import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroidapp.databinding.FragmentCalendarBinding
import com.example.myandroidapp.model.Reservation
import com.example.myandroidapp.MainActivity
import com.example.myandroidapp.viewmodel.CarViewModel
import com.example.myandroidapp.viewmodel.ReservationViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private val carViewModel: CarViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).carViewModelFactory }
    private val reservationViewModel: ReservationViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).reservationViewModelFactory }
    private val adapter = DayReservationAdapter(
        onDoubleTapReservation = { reservation -> showReservationDialog(reservation) },
        onDoubleTapEmpty = { dayStart -> showReservationDialog(null, dayStart) }
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerCalendar.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCalendar.adapter = adapter

        // simplistic: show next 14 days
        val days = (0 until 14).map { offset ->
            val cal = Calendar.getInstance()
            cal.add(Calendar.DAY_OF_YEAR, offset)
            cal.timeInMillis
        }
        adapter.submitDays(days)

        viewLifecycleOwner.lifecycleScope.launch {
            reservationViewModel.uiState.collectLatest { resState ->
                carViewModel.uiState.collectLatest { carState ->
                    adapter.updateData(days, carState.cars, resState.reservations)
                }
            }
        }
    }

    private fun showReservationDialog(reservation: Reservation?, dayStart: Long? = null) {
        val dialog = ReservationDialog(reservation, dayStart)
        dialog.show(parentFragmentManager, "ReservationDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
