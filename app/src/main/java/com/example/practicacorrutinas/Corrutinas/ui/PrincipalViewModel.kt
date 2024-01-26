package com.example.practicacorrutinas.Corrutinas.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class PrincipalViewModel {
    var texto by mutableStateOf("")
    var color by mutableStateOf(Color.Red)
    var contador by mutableStateOf(0)

    fun cambioColor(){
        color = if (color == Color.Red) Color.Blue else Color.Red
    }
    fun llamarApi():Int{
        contador++
        Thread.sleep(5000)
        return contador
    }
    fun textofun():String{
        if (contador==1){
        texto="Respuesta de la api"+contador
        return texto
        }
        return texto
    }
}
