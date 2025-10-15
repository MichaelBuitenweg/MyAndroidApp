package com.example.myandroidapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
<<<<<<< HEAD
import com.example.myandroidapp.MainActivity
import com.example.myandroidapp.databinding.DayCellBinding
=======
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myandroidapp.MainActivity
>>>>>>> 29e7c6c (added calender and colors)
import com.example.myandroidapp.databinding.FragmentCalendarBinding
import com.example.myandroidapp.viewmodel.CarViewModel
import com.example.myandroidapp.viewmodel.ReservationViewModel
import com.kizitonwose.calendar.core.DayPosition
import java.time.YearMonth
import com.kizitonwose.calendar.view.MonthDayBinder
import com.kizitonwose.calendar.view.ViewContainer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
<<<<<<< HEAD
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import androidx.appcompat.app.AlertDialog
import java.time.format.DateTimeFormatter
=======
import java.util.Calendar
import java.util.Locale
>>>>>>> 29e7c6c (added calender and colors)

class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private val carViewModel: CarViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).carViewModelFactory }
    private val reservationViewModel: ReservationViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).reservationViewModelFactory }

<<<<<<< HEAD
    private val firstDayOfWeek: DayOfWeek = DayOfWeek.MONDAY
    private var currentMonth: YearMonth = YearMonth.now()
=======
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
>>>>>>> 29e7c6c (added calender and colors)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
<<<<<<< HEAD
        try {
            setupCalendar()
        } catch (t: Throwable) {
            android.util.Log.e("CalendarFragment", "Calendar setup failed", t)
            // Minimal fallback: show a simple error text so app doesn't just close silently
            binding.textMonth.text = "Calendar error"
        }
        binding.buttonPrevMonth.setOnClickListener { updateMonth(currentMonth.minusMonths(1)) }
        binding.buttonNextMonth.setOnClickListener { updateMonth(currentMonth.plusMonths(1)) }

        viewLifecycleOwner.lifecycleScope.launch {
            launch { reservationViewModel.uiState.collectLatest { binding.calendarView.notifyCalendarChanged() } }
            launch { carViewModel.uiState.collectLatest { binding.calendarView.notifyCalendarChanged() } }
        }
    }

    private fun setupCalendar() {
        val startMonth = currentMonth.minusMonths(12)
        val endMonth = currentMonth.plusMonths(12)
    val cv = binding.calendarView
    cv.setup(startMonth, endMonth, firstDayOfWeek)
    cv.scrollToMonth(currentMonth)
        binding.textMonth.text = monthLabel(currentMonth)

        class DayContainer(view: View) : ViewContainer(view) {
            val dayBinding = DayCellBinding.bind(view)
            lateinit var date: LocalDate
            init {
                view.setOnClickListener {
                    if (dayBinding.textDayNumber.text.isNotEmpty()) {
                        showReservationDialog(null, date.toEpochDayMillis())
                    }
=======
        binding.recyclerCalendar.layoutManager = GridLayoutManager(requireContext(), 7)
        binding.recyclerCalendar.adapter = adapter
        binding.buttonPrevMonth.setOnClickListener { changeMonth(-1) }
        binding.buttonNextMonth.setOnClickListener { changeMonth(1) }
        generateMonthDays()

        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                reservationViewModel.uiState.collectLatest { resState ->
                    adapter.submit(monthDays, resState.reservations)
>>>>>>> 29e7c6c (added calender and colors)
                }
                view.setOnLongClickListener {
                    showDayReservationsDialog(date)
                    true
                }
            }
        }

        binding.calendarView.dayBinder = object : MonthDayBinder<DayContainer> {
            override fun create(view: View): DayContainer {
                val cell = LayoutInflater.from(view.context).inflate(com.example.myandroidapp.R.layout.day_cell, binding.calendarView, false)
                return DayContainer(cell)
            }
            override fun bind(container: DayContainer, data: com.kizitonwose.calendar.core.CalendarDay) {
                container.date = data.date
                val inMonth = data.position == DayPosition.MonthDate
                val dayText = if (inMonth) data.date.dayOfMonth.toString() else ""
                container.dayBinding.textDayNumber.text = dayText
                // Highlight today
                if (inMonth && data.date == LocalDate.now()) {
                    container.dayBinding.textDayNumber.setTextColor(resources.getColor(android.R.color.holo_blue_dark, null))
                } else {
                    container.dayBinding.textDayNumber.setTextColor(resources.getColor(android.R.color.black, null))
                }
                val stripesView = container.dayBinding.stripesView
                if (dayText.isEmpty()) {
                    stripesView.setStripeColors(emptyList())
                    return
                }
                val state = reservationViewModel.uiState.value
                val resList = state.reservations.filter { overlaps(it, data.date) }
                val colors = resList.mapNotNull { r ->
                    val carsState = carViewModel.uiState.value
                    carsState.cars.find { it.id == r.carId }?.color
                }.map { parseColorSafe(it) }
                stripesView.setStripeColors(colors)
                if (resList.size > 15) {
                    stripesView.contentDescription = "+${resList.size - 15} more reservations"
                } else {
                    stripesView.contentDescription = null
                }
                // Double tap stripes to edit first reservation (optional enhancement later)
            }
            launch {
                carViewModel.uiState.collectLatest { _ -> adapter.notifyDataSetChanged() }
            }
        }
    }

<<<<<<< HEAD
    private fun showDayReservationsDialog(date: LocalDate) {
        val reservations = reservationViewModel.uiState.value.reservations.filter { overlaps(it, date) }
        if (reservations.isEmpty()) {
            showReservationDialog(null, date.toEpochDayMillis())
            return
        }
        val cars = carViewModel.uiState.value.cars
        val fmt = DateTimeFormatter.ofPattern("MMM d")
        val items = reservations.map { r ->
            val car = cars.find { it.id == r.carId }
            val start = millisToLocalDate(r.startDate)
            val end = millisToLocalDate(r.endDate)
            val range = if (start == end) start.format(fmt) else start.format(fmt) + " - " + end.format(fmt)
            (car?.name ?: "Car") + " (" + (car?.licenseNumber ?: "?") + ") " + range
        } + listOf("+ Add new reservation")
        AlertDialog.Builder(requireContext())
            .setTitle(date.format(DateTimeFormatter.ofPattern("EEEE, MMM d")))
            .setItems(items.toTypedArray()) { _, which ->
                if (which == reservations.size) {
                    showReservationDialog(null, date.toEpochDayMillis())
                } else {
                    showReservationDialog(reservations[which])
                }
            }
            .setNegativeButton("Close", null)
            .show()
    }

    private fun overlaps(res: com.example.myandroidapp.model.Reservation, date: LocalDate): Boolean {
        val startDay = millisToLocalDate(res.startDate)
        val endDay = millisToLocalDate(res.endDate)
        return !date.isBefore(startDay) && !date.isAfter(endDay)
    }

    private fun millisToLocalDate(ms: Long): LocalDate = java.time.Instant.ofEpochMilli(ms).atZone(java.time.ZoneId.systemDefault()).toLocalDate()
    private fun LocalDate.toEpochDayMillis(): Long = this.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()

    private fun parseColorSafe(hex: String): Int = try { android.graphics.Color.parseColor(hex) } catch (_: Exception) { android.graphics.Color.LTGRAY }

    private fun updateMonth(month: YearMonth) {
        currentMonth = month
        binding.calendarView.scrollToMonth(month)
        binding.textMonth.text = monthLabel(month)
    }

    private fun monthLabel(month: YearMonth): String = month.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + month.year

=======
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

>>>>>>> 29e7c6c (added calender and colors)
    private fun showReservationDialog(reservation: com.example.myandroidapp.model.Reservation?, dayStart: Long? = null) {
        ReservationDialog(reservation, dayStart).show(parentFragmentManager, "ReservationDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
