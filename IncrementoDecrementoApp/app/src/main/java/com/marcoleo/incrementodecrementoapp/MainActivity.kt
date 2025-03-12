package com.marcoleo.incrementodecrementoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ImagenSizeApp() }
    }
}

@Composable
fun ImagenSizeApp() {
    var tamaño by remember { mutableStateOf(150.dp) }
    val tamañoMin = 100.dp
    val tamañoMax = 300.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        Image(
            painter = painterResource(id = R.drawable.gatomeme),
            contentDescription = "Imagen ajustable",
            modifier = Modifier.size(tamaño)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { if (tamaño < tamañoMax) tamaño += 20.dp },
                enabled = tamaño < tamañoMax
            ) {
                Text("Aumentar")
            }

            Button(
                onClick = { if (tamaño > tamañoMin) tamaño -= 20.dp },
                enabled = tamaño > tamañoMin
            ) {
                Text("Reducir")
            }
        }
    }
}