package com.example.myandroidapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidapp.R
import com.example.myandroidapp.model.Car
import com.example.myandroidapp.model.Reservation
import java.util.Calendar
import java.util.Date

class CalendarMonthAdapter(
    private val onDayClick: (Long) -> Unit,
    private val onReservationDoubleTap: (Reservation) -> Unit,
    private val resolveCarColor: (carId: Long) -> String?
) : RecyclerView.Adapter<CalendarMonthAdapter.DayVH>() {

    private val dayTimestamps = mutableListOf<Long>() // start of day millis
    private val reservations = mutableListOf<Reservation>()

    fun submit(monthDays: List<Long>, reservationList: List<Reservation>) {
        dayTimestamps.clear(); dayTimestamps.addAll(monthDays)
        reservations.clear(); reservations.addAll(reservationList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayVH {
        return DayVH(LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_day, parent, false))
    }

    override fun getItemCount(): Int = dayTimestamps.size

    override fun onBindViewHolder(holder: DayVH, position: Int) = holder.bind(dayTimestamps[position])

    inner class DayVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textDay: TextView = itemView.findViewById(R.id.textDayNumber)
        private val dotsContainer: ViewGroup = itemView.findViewById(R.id.reservationDots)

        fun bind(dayStart: Long) {
            val cal = Calendar.getInstance().apply { timeInMillis = dayStart }
            textDay.text = cal.get(Calendar.DAY_OF_MONTH).toString()
            dotsContainer.removeAllViews()
            val dayReservations = reservations.filter { overlapsDay(it, dayStart) }
            dayReservations.take(4).forEach { res ->
                val v = View(itemView.context)
                val color = resolveCarColor(res.carId)?.let { safeParseColor(it) } ?: Color.LTGRAY
                v.setBackgroundColor(color)
                val lp = ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 8)
                lp.bottomMargin = 2
                dotsContainer.addView(v, lp)
                v.setOnClickListener { /* swallow */ }
                v.setOnLongClickListener { onReservationDoubleTap(res); true }
                v.setOnTouchListener(DoubleTapListener { onReservationDoubleTap(res) })
            }
            itemView.setOnClickListener { onDayClick(dayStart) }
        }

        private fun overlapsDay(res: Reservation, dayStart: Long): Boolean {
            val startOfDay = dayStart
            val endOfDay = dayStart + 24*60*60*1000 - 1
            return res.startDate <= endOfDay && res.endDate >= startOfDay
        }

        private fun safeParseColor(hex: String): Int = try { Color.parseColor(hex) } catch (e: Exception) { Color.LTGRAY }
    }
}

// Simple double tap detector without GestureDetector to keep dependencies minimal
private class DoubleTapListener(private val onDouble: () -> Unit) : View.OnTouchListener {
    private var lastTapTime = 0L
    override fun onTouch(v: View, event: android.view.MotionEvent): Boolean {
        if (event.action == android.view.MotionEvent.ACTION_DOWN) {
            val now = System.currentTimeMillis()
            if (now - lastTapTime < 300) {
                onDouble()
                lastTapTime = 0
            } else {
                lastTapTime = now
            }
        }
        return false
    }
}