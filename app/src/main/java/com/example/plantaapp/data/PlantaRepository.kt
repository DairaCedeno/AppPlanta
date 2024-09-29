//El repositorio recibe y guarda datos en la base de datos y obtiene información cuando lo necesites.

package com.example.plantaapp.data

class PlantaRepository(private val plantaDao: PlantaDao) {
    suspend fun insert(planta: Planta) {
        plantaDao.insert(planta)
    }

    suspend fun getAllPlantas(): List<Planta> {
        return plantaDao.getAllPlantas()
    }
}

