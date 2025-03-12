package com.marcoleo.sumaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.text.KeyboardOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SumaApp() }
    }
}

@Composable
fun SumaApp() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Resultado en grande en la parte superior
        Text(
            text = "Resultado: $resultado",
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 50.dp),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Campo de texto para el primer número
            OutlinedTextField(
                value = num1,
                onValueChange = { num1 = it },
                label = { Text("Número 1") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para el segundo número
            OutlinedTextField(
                value = num2,
                onValueChange = { num2 = it },
                label = { Text("Número 2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Botón de suma en la parte inferior
        Button(
            onClick = {
                val n1 = num1.toIntOrNull() ?: 0
                val n2 = num2.toIntOrNull() ?: 0
                resultado = n1 + n2
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Sumar")
        }
    }
}