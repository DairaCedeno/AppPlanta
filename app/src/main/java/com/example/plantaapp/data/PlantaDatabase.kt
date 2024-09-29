// Aqui se define la base de datos que utiliza mi aplicación.

package com.example.plantaapp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [Planta::class], version = 1)
abstract class PlantaDatabase : RoomDatabase() {
    abstract fun plantaDao(): PlantaDao

    companion object {
        @Volatile
        private var INSTANCE: PlantaDatabase? = null

        fun getDatabase(context: Context): PlantaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantaDatabase::class.java,
                    "planta_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}


