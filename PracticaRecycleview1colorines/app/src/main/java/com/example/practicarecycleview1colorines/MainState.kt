package com.example.practicarecycleview1colorines

import com.example.practicarecycleview1colorines.model.Datos

class MainState {
    var listaColores= mutableListOf(MyColor("",""))
    fun devuelveArray() :List<MyColor>{
       listaColores = mutableListOf(    MyColor("Verde", "#FF4CAF50"),
            MyColor("Amarillo", "#FFEB3B"),
            MyColor("Azul", "#FF2196F3"),
            MyColor("Indigo", "#FF3F51B5"),
            MyColor("Rojo", "#FFF44336"),
            MyColor("Naranja", "#FFFF9800"),
            MyColor("Violeta", "#FF9C27B0"),
            MyColor("Cyan", "#FF00BCD4"),
            MyColor("Rosa", "#FFE91E63"),
            MyColor("Gris", "#FF9E9E9E"),
            MyColor("Lima", "#FFCDDC39"),
            MyColor("Marrón", "#FF795548"),
            MyColor("Ámbar", "#FFFFC107"),
            MyColor("Turquesa", "#FF008080"),
            MyColor("Celeste", "#FF87CEEB"),
            MyColor("Lavanda", "#FFE6E6FA"),
            MyColor("Dorado", "#FFFFD700"),
            MyColor("Plateado", "#FFC0C0C0"),
            MyColor("Magenta", "#FFFF00FF"),
            MyColor("Oliva", "#FF808000")
        )
        return listaColores
    }

    fun borrar(position: Int):Datos{
        listaColores.removeAt(position)
        return Datos(position,listaColores)
    }
    fun aniadir(position: Int, name: String, code:String): Datos {
        listaColores.add(position,  MyColor(name,code))
        return Datos(position,listaColores)
    }
}