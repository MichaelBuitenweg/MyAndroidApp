package com.example.myandroidapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroidapp.databinding.FragmentCarsBinding
import com.example.myandroidapp.model.Car
import com.example.myandroidapp.viewmodel.CarViewModel
import com.example.myandroidapp.MainActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CarsFragment : Fragment() {
    private var _binding: FragmentCarsBinding? = null
    private val binding get() = _binding!!

    private val carViewModel: CarViewModel by viewModels({ requireActivity() }) { (requireActivity() as MainActivity).carViewModelFactory }
    private val adapter = CarListAdapter(onDelete = { carViewModel.deleteCar(it) })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerCars.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCars.adapter = adapter
        binding.buttonAddCar.setOnClickListener { showAddCarDialog() }

        viewLifecycleOwner.lifecycleScope.launch {
            carViewModel.uiState.collectLatest { state ->
                adapter.submitList(state.cars)
            }
        }
    }

    private fun showAddCarDialog() {
        val dialog = AddCarDialog { name, model, license, color ->
            carViewModel.addCar(name, model, license, color) { success, _ ->
                if (!success) {
                    // TODO: surface add car failure (e.g., Snackbar). For now we ignore to keep UI minimal.
                }
            }
        }
        dialog.show(parentFragmentManager, "AddCarDialog")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
