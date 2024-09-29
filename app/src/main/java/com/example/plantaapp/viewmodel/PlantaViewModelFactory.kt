//Crea instancias de PlantaViewModel y les proporciona el repositorio necesario para su funcionamiento.


package com.example.plantaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.plantaapp.data.PlantaRepository

class PlantaViewModelFactory(private val repository: PlantaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlantaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlantaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

