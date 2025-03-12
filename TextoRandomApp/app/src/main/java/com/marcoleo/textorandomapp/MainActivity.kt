package com.marcoleo.textorandomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marcoleo.textorandomapp.ui.theme.TextoRandomAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TextoRandomAppTheme() }
    }
}

@Composable
fun TextoRandomAppTheme() {
    val messages = listOf("Hola!", "Bienvenido", "Gracias ITCM por...", "Ingenieria en Sistemas", "Android Studio Sucks")
    var text by remember { mutableStateOf(messages[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { text = messages.random() }) {
            Text("Cambiar Texto")
        }
    }
}