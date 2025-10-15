package com.example.myandroidapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidapp.databinding.ItemCarBinding
import com.example.myandroidapp.model.Car

class CarListAdapter(private val onDelete: (Car) -> Unit) : ListAdapter<Car, CarListAdapter.VH>(Diff) {
    object Diff : DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Car, newItem: Car) = oldItem == newItem
    }

    inner class VH(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car) {
            binding.textName.text = car.name
            binding.textModel.text = car.model
            binding.textLicense.text = car.licenseNumber
            try { binding.colorSwatch.setBackgroundColor(Color.parseColor(car.color)) } catch (_: Exception) {}
            binding.buttonDelete.setOnClickListener { onDelete(car) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}
