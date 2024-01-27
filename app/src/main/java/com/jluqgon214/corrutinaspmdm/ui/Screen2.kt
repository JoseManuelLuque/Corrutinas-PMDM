package com.jluqgon214.corrutinaspmdm.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.jluqgon214.corrutinaspmdm.viewmodel.ViewModel

/**
 * Pantalla 2
 *
 * Pantalla usando las variables mutableStateOf()
 */

@Composable
fun Screen2(
    viewModel: ViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.colorButtonState= !viewModel.colorButtonState
                navController.navigate("Carga")
                Log.e("Test", "${viewModel.colorButtonState}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = viewModel.CambiarColor2())
        ) {
            Text(text = "Cambiar Color", color = Color.White)
        }

        Text(text = viewModel.textApiState)

        Button(onClick = {
            viewModel.fetchData()
            navController.navigate("Carga")
        }) {
            Text(text = "Llamar API")
        }

    }
}