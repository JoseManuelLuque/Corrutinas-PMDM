package com.jluqgon214.corrutinaspmdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.corrutinaspmdm.ui.Screen2
import com.jluqgon214.corrutinaspmdm.ui.theme.CorrutinasPMDMTheme
import com.jluqgon214.corrutinaspmdm.viewmodel.ViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CorrutinasPMDMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "Screen"
                    ) {
                        composable("Screen"){
                            Screen2(viewModel, navController)
                        }
                        composable("Carga") {
                            PantallaCarga(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun PantallaCarga(navController: NavController) {
    navController.navigate("Screen")
}