package com.jluqgon214.corrutinaspmdm.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModel(application: Application) : AndroidViewModel(application) {
    //Parte 1: Mutable Live Data
    var colorButton = MutableLiveData<Boolean>(true)
    var textApi = MutableLiveData<String>("")
    var contApi = MutableLiveData<Int>(0)

    fun CambiarColor(): Color {
        if (colorButton.value!!) {
            return Color.Blue
        }
        else {
            return Color.Red
        }

    }

    fun bloqueoApp(viewModel: ViewModel) {
        Thread.sleep(5000)
        viewModel.contApi.value = viewModel.contApi.value?.plus(1)
        viewModel.textApi.value = "Respuesta de la API (${viewModel.contApi.value})"
    }

    //Parte 1: mutableStateOf()
    var colorButtonState by mutableStateOf(true)
    var textApi2State by mutableStateOf("")
    var contApi2State by mutableStateOf(0)

    fun CambiarColor2(): Color {
        if (colorButtonState) {
            return Color.Blue
        }
        else {
            return Color.Red
        }

    }

    fun bloqueoApp2(viewModel: ViewModel) {
        Thread.sleep(5000)
        viewModel.contApi2State = viewModel.contApi2State.plus(1)
        viewModel.textApi2State = "Respuesta de la API (${ viewModel.contApi2State})"
    }


}