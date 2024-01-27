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
 * Pantalla 1
 *
 * Pantalla usando las variables de Live Data en el ViewModel
 */
@Composable
fun Screen(
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
                viewModel.colorButton.value = !viewModel.colorButton.value!!
                navController.navigate("Carga")
                Log.e("Test", "${viewModel.colorButton.value}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = viewModel.CambiarColor())
        ) {
            Text(text = "Cambiar Color", color = Color.White)
        }

        Text(text = viewModel.textApi.value!!)

        Button(onClick = {
            viewModel.bloqueoApp()
            navController.navigate("Carga")
        }) {
            Text(text = "Llamar API")
        }

    }
}