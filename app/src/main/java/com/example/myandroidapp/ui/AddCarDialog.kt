package com.example.myandroidapp.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.myandroidapp.databinding.DialogAddCarBinding

class AddCarDialog(private val onSubmit: (String, String, String, String) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddCarBinding.inflate(LayoutInflater.from(context))
        // Setup color spinner
        val names = resources.getStringArray(com.example.myandroidapp.R.array.car_color_names)
        val values = resources.getStringArray(com.example.myandroidapp.R.array.car_color_values)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, names)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerColor.adapter = adapter

        return AlertDialog.Builder(requireContext())
            .setTitle("Add Car")
            .setView(binding.root)
            .setPositiveButton("Save") { _, _ ->
                val name = binding.inputName.text.toString().trim()
                val model = binding.inputModel.text.toString().trim()
                val license = binding.inputLicense.text.toString().trim()
                val colorIndex = binding.spinnerColor.selectedItemPosition.takeIf { it in values.indices } ?: 0
                val color = values[colorIndex]
                onSubmit(name, model, license, color)
            }
            .setNegativeButton("Cancel", null)
            .create()
    }
}
