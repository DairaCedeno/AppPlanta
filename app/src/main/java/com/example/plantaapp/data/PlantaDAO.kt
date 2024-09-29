// Funciona como un "puente" entre la aplicación y la base de datos.

package com.example.plantaapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlantaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(planta: Planta)

    @Query("SELECT * FROM planta_table")
    suspend fun getAllPlantas(): List<Planta>
}

