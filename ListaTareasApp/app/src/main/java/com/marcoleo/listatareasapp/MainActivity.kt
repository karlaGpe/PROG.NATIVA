package com.marcoleo.listatareasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ListaTareasApp() }
    }
}

@Composable
fun ListaTareasApp() {
    var nuevaTarea by remember { mutableStateOf("") }
    val tareas = remember { mutableStateListOf<Tarea>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la lista
        Text(
            text = "Lista de Tareas",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de texto para nueva tarea
        OutlinedTextField(
            value = nuevaTarea,
            onValueChange = { nuevaTarea = it },
            label = { Text("Nueva tarea") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para agregar tarea (máximo 5)
        Button(
            onClick = {
                if (tareas.size < 5 && nuevaTarea.isNotBlank()) {
                    tareas.add(Tarea(nuevaTarea, false))
                    nuevaTarea = "" // Limpiar campo de texto
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = tareas.size < 5
        ) {
            Text("Agregar Tarea (${tareas.size}/5)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de tareas
        LazyColumn {
            items(tareas) { tarea ->
                FilaTarea(tarea) { tarea.completada = it }
            }
        }
    }
}

// Modelo de datos para una tarea
data class Tarea(val nombre: String, var completada: Boolean)

// Composable para mostrar cada tarea con un checkbox
@Composable
fun FilaTarea(tarea: Tarea, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = tarea.completada,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = tarea.nombre,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}