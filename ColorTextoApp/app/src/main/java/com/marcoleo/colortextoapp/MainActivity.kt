package com.marcoleo.colortextoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CambioColorTextoApp() }
    }
}

@Composable
fun CambioColorTextoApp() {
    var colorTexto by remember { mutableStateOf(Color.Black) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Texto en la parte superior con color dinámico
        Text(
            text = "Bienvenido a la Clase Programación Nativas para Móviles",
            fontSize = 24.sp,
            color = colorTexto,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 50.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botón para cambiar el color del texto
        Button(
            onClick = { colorTexto = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat()) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Cambiar Color")
        }
    }
}