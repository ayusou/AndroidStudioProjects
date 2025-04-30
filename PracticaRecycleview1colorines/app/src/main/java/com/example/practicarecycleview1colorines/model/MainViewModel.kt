package com.example.recycleview.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicarecycleview1colorines.MyColor
import com.example.practicarecycleview1colorines.MainState
import com.example.practicarecycleview1colorines.model.Datos
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val _datos = MutableLiveData<List<MyColor>>(emptyList())
    val datos: LiveData<List<MyColor>> get()=_datos
    val miEstado = MainState()

    val _borrar: MutableLiveData<Datos> = MutableLiveData<Datos>()

    private val _aniadir :MutableLiveData<Datos> = MutableLiveData<Datos>()

    val borrar : LiveData<Datos> get() =_borrar
    val aniadir : LiveData<Datos> get() =_aniadir

    fun devuelveArray(){
     var returndata = miEstado.devuelveArray()

        _datos.value=returndata
    }

    fun borrar(position: Int){
        viewModelScope.launch {
            var returndata = miEstado.borrar(position)
            _borrar.value = returndata
        }
    }

    fun aniadir(position: Int, nombre: String, code: String){
        viewModelScope.launch {
            var returndata = miEstado.aniadir(position, nombre,code)
            _aniadir.value = returndata
        }
    }
}