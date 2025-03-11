package com.marcoleo.botonoculto

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
import com.marcoleo.botonoculto.ui.theme.BotonOcultoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BotonOcultoTheme{
                DadoScreen()
            }
        }
    }
}

@Composable
fun DadoScreen() {
    var isVisible by remember{ mutableStateOf(true)}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp)) // Espacio superior

        if (isVisible) {
            Image(
                painter = painterResource(id = R.drawable.dado),
                contentDescription = "Imagen del dado",
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // Empuja el botón hacia abajo

        Button(
            onClick = { isVisible = !isVisible },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(if (isVisible) "Ocultar Dado" else "Mostrar Dado")
        }
    }
}