package com.example.practicacorrutinas.Corrutinas.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalViewModel :ViewModel(){
    var texto by mutableStateOf("")
    var color by mutableStateOf(Color.Red)
    var contador by mutableStateOf(0)

    fun cambioColor(){
        if (color== Color.Red){
                color= Color.Blue
            }else{
                color= Color.Red
        }
    }
    fun fetchData() {
        contador = contador.plus(1)
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                "Respuesta de la API ($contador)"
            }
            texto = result
        }
    }
}
