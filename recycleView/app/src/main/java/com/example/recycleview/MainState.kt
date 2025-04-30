package com.example.recycleview

import com.example.recycleview.model.Datos

class MainState {
    var animalNames = mutableListOf("")
    fun devuelveArray() :List<String>{
      animalNames = mutableListOf("Caballo", "Vaca", "Gallina", "Cerdo", "Oveja", "Leon","Tigre","Serpiente", "Oso","Rinoceronte","Elefante","Pollo","Tiranosaurio rex", "Anquilosaurio", "Pteranodon")
        return animalNames
    }
    fun borrar(position: Int):Datos{
        animalNames.removeAt(position)
        return Datos(position,animalNames)
    }
    fun aniadir(position: Int, nombre:String):Datos{
        animalNames.add(position,nombre)
        return Datos(position,animalNames)
    }
}