package com.example.lifeciclegameplay.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeciclegameplay.model.Datos
import com.example.lifeciclegameplay.model.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModelFlows : ViewModel() {

        private val _datos = MutableStateFlow(Datos(0,0,false))
        val datos: StateFlow<Datos> get() = _datos.asStateFlow()
        val myEstado = MainState()

        fun sumar(valor:Int, misDatos: Datos){
            viewModelScope.launch {
                var retornoDatos = myEstado.sumar(valor,misDatos)
                _datos.value =retornoDatos
            }
        }

}