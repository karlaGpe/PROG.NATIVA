package com.example.botonfondo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BotonFondoApp()
        }
    }
}

@Composable
fun BotonFondoApp() {
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable {
                backgroundColor = Color(
                    (0..255).random() / 255f,
                    (0..255).random() / 255f,
                    (0..255).random() / 255f
                )
            },
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = "Toca para cambiar el color",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )
    }
}

