package com.example.myandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myandroidapp.data.AppDatabase
import com.example.myandroidapp.repository.CarRepository
import com.example.myandroidapp.repository.ReservationRepository
import com.example.myandroidapp.ui.SectionsPagerAdapter
import com.example.myandroidapp.viewmodel.CarViewModel
import com.example.myandroidapp.viewmodel.ReservationViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var database: AppDatabase
        private set
    lateinit var carViewModelFactory: CarViewModel.Factory
        private set
    lateinit var reservationViewModelFactory: ReservationViewModel.Factory
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AppDatabase.getDatabase(this)
        carViewModelFactory = CarViewModel.Factory(CarRepository(database.carDao()))
        reservationViewModelFactory = ReservationViewModel.Factory(ReservationRepository(database.reservationDao()))

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val pagerAdapter = SectionsPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Calendar"
                else -> "Cars"
            }
        }.attach()
    }
}