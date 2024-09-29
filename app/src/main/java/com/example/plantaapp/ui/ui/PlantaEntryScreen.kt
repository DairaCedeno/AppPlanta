// Aquí se define la pantalla de ingreso de datos para agregar una planta en la aplicación.

package com.example.plantaapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.plantaapp.data.Planta
import com.example.plantaapp.viewmodel.PlantaViewModel

@Composable
fun PlantaEntryScreen(viewModel: PlantaViewModel, onSaveClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()  // Ocupa todo el tamaño de la pantalla
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,  // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally  // Centra horizontalmente
    ) {

        var nombre by remember { mutableStateOf("") }
        var tipo by remember { mutableStateOf("") }
        var riego by remember { mutableStateOf("") }
        var luz by remember { mutableStateOf("") }
        var cuidados by remember { mutableStateOf("") }

        Text(text = "Daira Elizabeth Cedeño Pazmiño", style = MaterialTheme.typography.titleLarge)
        Text(text = "--PLANTA--", style = MaterialTheme.typography.titleMedium)
        Text(text = "Séptimo B", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = tipo, onValueChange = { tipo = it }, label = { Text("Tipo") })
        TextField(value = riego, onValueChange = { riego = it }, label = { Text("Riego (días)") })
        TextField(value = luz, onValueChange = { luz = it }, label = { Text("Luz") })
        TextField(value = cuidados, onValueChange = { cuidados = it }, label = { Text("Cuidados") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val planta = Planta(nombre = nombre, tipo = tipo, riego = riego.toInt(), luz = luz, cuidados = cuidados)
            viewModel.insert(planta)
            nombre = ""
            tipo = ""
            riego = ""
            luz = ""
            cuidados = ""
        }) {
            Text("Agregar Planta")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onSaveClick() }) {
            Text("Ver Lista de Plantas")
        }
    }
}
