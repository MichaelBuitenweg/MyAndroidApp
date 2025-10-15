package com.example.myandroidapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myandroidapp.MainActivity
import com.example.myandroidapp.databinding.FragmentCalendarBinding
import com.example.myandroidapp.viewmodel.CarViewModel
import com.example.myandroidapp.viewmodel.ReservationViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private val carViewModel: CarViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).carViewModelFactory }
    private val reservationViewModel: ReservationViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).reservationViewModelFactory }

    private val monthDays = mutableListOf<Long>()
    private var currentMonthCal = Calendar.getInstance().apply {
        set(Calendar.DAY_OF_MONTH, 1)
        set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE,0); set(Calendar.SECOND,0); set(Calendar.MILLISECOND,0)
    }

    private val adapter = CalendarMonthAdapter(
        onDayClick = { dayStart -> showReservationDialog(null, dayStart) },
        onReservationDoubleTap = { reservation -> showReservationDialog(reservation) },
        resolveCarColor = { carId -> carViewModel.uiState.value.cars.find { it.id == carId }?.color }
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerCalendar.layoutManager = GridLayoutManager(requireContext(), 7)
        binding.recyclerCalendar.adapter = adapter
        binding.buttonPrevMonth.setOnClickListener { changeMonth(-1) }
        binding.buttonNextMonth.setOnClickListener { changeMonth(1) }
        generateMonthDays()

        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                reservationViewModel.uiState.collectLatest { resState ->
                    adapter.submit(monthDays, resState.reservations)
                }
            }
            launch {
                carViewModel.uiState.collectLatest { _ -> adapter.notifyDataSetChanged() }
            }
        }
    }

    private fun generateMonthDays() {
        monthDays.clear()
        val cal = currentMonthCal.clone() as Calendar
        val month = cal.get(Calendar.MONTH)
        while (cal.get(Calendar.MONTH) == month) {
            monthDays.add(cal.timeInMillis)
            cal.add(Calendar.DAY_OF_MONTH, 1)
        }
        binding.textMonth.text = String.format(Locale.getDefault(), "%1\$tB %1\$tY", currentMonthCal.time)
        adapter.submit(monthDays, reservationViewModel.uiState.value.reservations)
    }

    private fun changeMonth(delta: Int) {
        currentMonthCal.add(Calendar.MONTH, delta)
        generateMonthDays()
    }

    private fun showReservationDialog(reservation: com.example.myandroidapp.model.Reservation?, dayStart: Long? = null) {
        ReservationDialog(reservation, dayStart).show(parentFragmentManager, "ReservationDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
