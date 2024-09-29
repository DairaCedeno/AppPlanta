//Aquí se define la pantalla que muestra una lista de plantas almacenadas en la aplicación.

package com.example.plantaapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.plantaapp.viewmodel.PlantaViewModel

@Composable
fun PlantaListScreen(viewModel: PlantaViewModel, modifier: Modifier = Modifier) {
    val plantas by viewModel.plantas.observeAsState(emptyList())

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Lista de Plantas", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(plantas) { planta ->
                // Tarjeta para cada planta
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(text = planta.nombre, style = MaterialTheme.typography.titleMedium)
                    Text(text = "Tipo: ${planta.tipo}")
                    Text(text = "Riego: Cada ${planta.riego} días")
                    Text(text = "Luz: ${planta.luz}")

                    Divider(modifier = Modifier.padding(top = 8.dp)) // Separador entre plantas
                }
            }
        }
    }
}





