package com.example.myandroidapp.ui

import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidapp.databinding.ItemDayReservationsBinding
import com.example.myandroidapp.model.Car
import com.example.myandroidapp.model.Reservation
import java.text.SimpleDateFormat
import java.util.*

class DayReservationAdapter(
    private val onDoubleTapReservation: (Reservation) -> Unit,
    private val onDoubleTapEmpty: (Long) -> Unit
) : RecyclerView.Adapter<DayReservationAdapter.VH>() {

    private val days = mutableListOf<Long>()
    private val cars = mutableListOf<Car>()
    private val reservations = mutableListOf<Reservation>()

    fun submitDays(dayList: List<Long>) {
        days.clear(); days.addAll(dayList); notifyDataSetChanged()
    }

    fun updateData(dayList: List<Long>, carList: List<Car>, reservationList: List<Reservation>) {
        days.clear(); days.addAll(dayList)
        cars.clear(); cars.addAll(carList)
        reservations.clear(); reservations.addAll(reservationList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemDayReservationsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(days[position])
    }

    inner class VH(private val binding: ItemDayReservationsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        fun bind(dayStart: Long) {
            val dayReservations = reservations.filter { r -> isSameDay(r.startDate, dayStart) || isWithin(r, dayStart) }
            binding.textDate.text = dateFormat.format(Date(dayStart))
            val carLines = buildString {
                dayReservations.forEach { r ->
                    val car = cars.find { it.id == r.carId }
                    append("${car?.name ?: "Unknown"} : ")
                    append(dateFormat.format(Date(r.startDate)))
                    append(" -> ")
                    append(dateFormat.format(Date(r.endDate)))
                    append('\n')
                }
            }
            binding.textReservations.text = carLines.ifBlank { "(No reservations)" }

            val gestureDetector = GestureDetector(binding.root.context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onDoubleTap(e: MotionEvent): Boolean {
                    // Determine if tapped line corresponds to a reservation (simplistic: first one if exists)
                    if (dayReservations.isNotEmpty()) {
                        onDoubleTapReservation(dayReservations.first())
                    } else {
                        onDoubleTapEmpty(dayStart)
                    }
                    return true
                }
            })
            binding.root.setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
        }

        private fun isSameDay(time: Long, day: Long): Boolean {
            val cal1 = Calendar.getInstance().apply { timeInMillis = time; set(Calendar.HOUR_OF_DAY,0); set(Calendar.MINUTE,0); set(Calendar.SECOND,0); set(Calendar.MILLISECOND,0) }
            val cal2 = Calendar.getInstance().apply { timeInMillis = day; set(Calendar.HOUR_OF_DAY,0); set(Calendar.MINUTE,0); set(Calendar.SECOND,0); set(Calendar.MILLISECOND,0) }
            return cal1.timeInMillis == cal2.timeInMillis
        }

        private fun isWithin(reservation: Reservation, day: Long): Boolean {
            val startOfDay = Calendar.getInstance().apply { timeInMillis = day; set(Calendar.HOUR_OF_DAY,0); set(Calendar.MINUTE,0); set(Calendar.SECOND,0); set(Calendar.MILLISECOND,0) }.timeInMillis
            val endOfDay = startOfDay + 24*60*60*1000 - 1
            return reservation.startDate <= endOfDay && reservation.endDate >= startOfDay
        }
    }
}
