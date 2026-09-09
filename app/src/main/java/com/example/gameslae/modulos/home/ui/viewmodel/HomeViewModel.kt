package com.example.gameslae.modulos.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gameslae.modulos.home.domain.model.TipoSorteo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

data class HomeUiEstado(
    val tipoSorteo: TipoSorteo? = null,
    val numeroSorteo: Int? = null,
    val fecha: LocalDate? = null,
    val numeros: List<Int>? = null
)

class HomeViewModel(): ViewModel() {

    private val _estado = MutableStateFlow<HomeUiEstado>(HomeUiEstado())
    val estado: StateFlow<HomeUiEstado> get() = _estado

    fun initApp(){

    }
}