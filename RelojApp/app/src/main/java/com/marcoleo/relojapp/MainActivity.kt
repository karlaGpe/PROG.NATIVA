package com.marcoleo.relojapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { RelojApp() }
    }
}

@Composable
fun RelojApp() {
    var horaActual by remember { mutableStateOf(obtenerHoraActual()) }
    var fechaActual by remember { mutableStateOf(obtenerFechaActual()) }

    // Actualiza la hora cada segundo
    LaunchedEffect(Unit) {
        while (true) {
            horaActual = obtenerHoraActual()
            fechaActual = obtenerFechaActual()
            delay(1000) // Espera 1 segundo
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = fechaActual,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = horaActual,
            fontSize = 50.sp,
            textAlign = TextAlign.Center
        )
    }
}

// Función para obtener la hora actual
fun obtenerHoraActual(): String {
    val formatoHora = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return formatoHora.format(Date())
}

// Función para obtener la fecha actual
fun obtenerFechaActual(): String {
    val formatoFecha = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
    return formatoFecha.format(Date())
}