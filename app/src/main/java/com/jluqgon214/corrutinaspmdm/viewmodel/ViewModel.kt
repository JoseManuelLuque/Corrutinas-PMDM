package com.jluqgon214.corrutinaspmdm.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel(application: Application) : AndroidViewModel(application) {
    //Parte 1: Mutable Live Data
    var colorButton = MutableLiveData<Boolean>(true)
    var textApi = MutableLiveData<String>("")
    var contApi = MutableLiveData<Int>(0)

    fun CambiarColor(): Color {
        return if (colorButton.value!!) {
            Color.Blue
        } else {
            Color.Red
        }

    }

    fun bloqueoApp() {
        Thread.sleep(5000)
        contApi.value = contApi.value?.plus(1)
        textApi.value = "Respuesta de la API (${contApi.value})"
    }

    //Parte 1: mutableStateOf()
    var colorButtonState by mutableStateOf(true)
    var textApiState by mutableStateOf("")
    var contApiState by mutableStateOf(0)

    fun CambiarColor2(): Color {
        return if (colorButtonState) {
            Color.Blue
        } else {
            Color.Red
        }

    }

    fun bloqueoApp2() {
        Thread.sleep(5000)
        contApiState = contApiState.plus(1)
        textApiState = "Respuesta de la API (${contApiState})"
    }

    //Parte 2: Implementacion de la Corrutina
    fun fetchData() {
        contApiState = contApiState.plus(1)
        //Nos permite crear una corrutina desde un ViewModel
        showText = false
        showProgress = true
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                "Respuesta de la API ($contApiState)"
            }
            showProgress = false
            textApiState = result
            showText = true
        }
    }

    //Parte 3
    var showProgress by mutableStateOf(false)
    var showText by mutableStateOf(false)

}