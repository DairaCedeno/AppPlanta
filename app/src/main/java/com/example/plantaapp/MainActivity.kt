package com.example.plantaapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.plantaapp.data.PlantaDatabase
import com.example.plantaapp.data.PlantaRepository
import com.example.plantaapp.ui.PlantaEntryScreen
import com.example.plantaapp.ui.PlantaListScreen
import com.example.plantaapp.ui.ui.theme.PlantaAppTheme
import com.example.plantaapp.viewmodel.PlantaViewModel
import com.example.plantaapp.viewmodel.PlantaViewModelFactory


class MainActivity : ComponentActivity() {
    private lateinit var plantaViewModel: PlantaViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicialización de la base de datos y repositorio
        val plantaDao = PlantaDatabase.getDatabase(application).plantaDao()
        val repository = PlantaRepository(plantaDao)
        plantaViewModel = ViewModelProvider(this, PlantaViewModelFactory(repository)).get(PlantaViewModel::class.java)

        // Configuración del contenido de la actividad
        setContent {
            PlantaAppTheme {
                var showListScreen by remember { mutableStateOf(false) }

                Scaffold { innerPadding ->
                    Column(modifier = Modifier.fillMaxSize()) {
                        if (showListScreen) {
                            PlantaListScreen(viewModel = plantaViewModel)
                        } else {
                            PlantaEntryScreen(viewModel = plantaViewModel) {
                                showListScreen = true // Cambia a la pantalla de lista de plantas
                            }
                        }
                    }
                }
            }
        }
    }
}