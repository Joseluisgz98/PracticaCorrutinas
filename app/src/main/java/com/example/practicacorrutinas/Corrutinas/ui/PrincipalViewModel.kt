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
    var boleano by mutableStateOf(false)

    fun cambioColor(){
        if (color== Color.Red){
                color= Color.Blue
            }else{
                color= Color.Red
        }
    }
    fun fetchData() {
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            try {
                boleano = true
                llamarApi()
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                boleano = false
            }
        }
    }
    //Solo funcionan dentro de una corrutina u otra función suspendida
    private suspend fun llamarApi() {
        contador = contador.plus(1)
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Respuesta de la API $contador"
        }
        texto = result
    }
}
