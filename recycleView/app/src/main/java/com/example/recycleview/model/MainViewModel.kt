package com.example.recycleview.model

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recycleview.MainState
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
     val _datos = MutableLiveData<List<String>>(emptyList())
    val datos: LiveData<List<String>> get()=_datos
    val miEstado = MainState()

     val _borrar: MutableLiveData<Datos> = MutableLiveData<Datos>()

    private val _aniadir :MutableLiveData<Datos> = MutableLiveData<Datos>()

    val borrar : LiveData<Datos> get() =_borrar
    val aniadir : LiveData<Datos> get() =_aniadir

    fun devuelveArray(){
        viewModelScope.launch {
            var returndata = miEstado.devuelveArray()
            _datos.value=returndata
        }

    }

    fun borrar(position: Int){
        viewModelScope.launch {
            var returndata = miEstado.borrar(position)
            _borrar.value = returndata
        }
    }

    fun aniadir(position: Int, nombre: String){
        viewModelScope.launch {
            var returndata = miEstado.aniadir(position, nombre)
            _aniadir.value = returndata
        }
    }

}