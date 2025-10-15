package com.example.myandroidapp.ui

import android.app.Dialog
import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.myandroidapp.databinding.DialogAddCarBinding

class AddCarDialog(private val onSubmit: (String, String, String, String) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddCarBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(requireContext())
            .setTitle("Add Car")
            .setView(binding.root)
            .setPositiveButton("Save") { _, _ ->
                val name = binding.inputName.text.toString().trim()
                val model = binding.inputModel.text.toString().trim()
                val license = binding.inputLicense.text.toString().trim()
                val color = binding.inputColor.text.toString().trim()
                onSubmit(name, model, license, color)
            }
            .setNegativeButton("Cancel", null)
            .create()
    }
}
