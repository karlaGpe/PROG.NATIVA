package com.marcoleo.numerorandom

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
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NumeroRandomApp() }
    }
}

@Composable
fun NumeroRandomApp() {
    var randomNumber by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Número aleatorio en grande en la parte superior
        Text(
            text = "$randomNumber",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 50.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botón centrado en la parte inferior
        Button(
            onClick = { randomNumber = Random.nextInt(1, 101) }, // Genera un número aleatorio del 1 al 100
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Generar Número Aleatorio")
        }
    }
}