//Gestiona los datos de las plantas y coordina la interacción entre la interfaz de usuario y el repositorio.

package com.example.plantaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantaapp.data.Planta
import com.example.plantaapp.data.PlantaRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PlantaViewModel(private val repository: PlantaRepository) : ViewModel() {
    private val _plantas = MutableLiveData<List<Planta>>()
    val plantas: LiveData<List<Planta>> get() = _plantas

    fun insert(planta: Planta) {
        viewModelScope.launch {
            repository.insert(planta)
            fetchAllPlantas()
        }
    }

    private suspend fun fetchAllPlantas() {
        _plantas.value = repository.getAllPlantas()
    }
}
