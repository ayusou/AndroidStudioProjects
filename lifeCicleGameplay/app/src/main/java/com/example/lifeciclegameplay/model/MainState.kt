package com.example.lifeciclegameplay.model

class MainState {

fun sumar(valor:Int, datos:Datos) : Datos{
    datos.contador+=valor
    datos.numClicks++
    if (datos.contador>=5){
        datos.mostrarMsg=true
        datos.numClicks=0
    }
    return datos
}

}