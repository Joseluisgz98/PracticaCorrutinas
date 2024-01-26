package com.example.practicacorrutinas.Corrutinas.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier



@Composable
    fun Pantalla(viewModel: PrincipalViewModel){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Button(
                onClick = {viewModel.cambioColor()},
                colors = ButtonDefaults.buttonColors(containerColor = viewModel.color),
            ) {
                Text("Cambiar color")
            }
            if (viewModel.boleano==true){
                CircularProgressIndicator()
            }else{
            Text(viewModel.texto)}

            Button(onClick = {viewModel.fetchData()}) {
                Text("Llamar API")
            }
        }
    }
}
