// Este archivo define una entidad que será utilizada por Room,

package com.example.plantaapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planta_table")
data class Planta(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val tipo: String,
    val riego: Int, // Frecuencia de riego en días
    val luz: String, // Luz necesaria
    val cuidados: String // Cuidados adicionales
)

