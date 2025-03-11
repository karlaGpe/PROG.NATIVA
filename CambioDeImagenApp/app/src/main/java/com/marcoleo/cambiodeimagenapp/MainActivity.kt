package com.marcoleo.cambiodeimagenapp

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
import com.marcoleo.cambiodeimagenapp.ui.theme.CambioDeImagenAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CambioDeImagenAppTheme() }
    }
}

@Composable
fun CambioDeImagenAppTheme() {
    var showFirstImage by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = if (showFirstImage) R.drawable.gato else R.drawable.gatomeme),
            contentDescription = "Imagen cambiable",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { showFirstImage = !showFirstImage }) {
            Text("Cambiar Imagen")
        }
    }
}