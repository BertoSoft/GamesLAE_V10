package com.example.gameslae.modulos.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameslae.modulos.home.domain.model.DatosHome
import com.example.gameslae.modulos.home.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiEstado(
    val lista: List<DatosHome>? = null,
    val isCargando: Boolean? = null,
    val msgError: String? = null
)

@HiltViewModel
class HomeViewModel@Inject constructor(
    private val usecase: HomeUseCase
): ViewModel() {

    private val _estado = MutableStateFlow<HomeUiEstado>(HomeUiEstado())
    val estado: StateFlow<HomeUiEstado> get() = _estado

    fun initApp(){
        _estado.update { estadoActual ->
            estadoActual.copy(
                isCargando = false
            )
        }
        viewModelScope.launch {
            try {
                val lista = usecase.getDatosUltimosSorteosUseCase()
                if(lista != emptyList<DatosHome>()){
                    _estado.update { estadoActual ->
                        estadoActual.copy(
                            lista = lista,
                            msgError = null,
                            isCargando = false
                        )
                    }
                }
                else{
                    _estado.update { estadoActual ->
                        estadoActual.copy(
                            msgError = "Lista de Sorteos Vacía",
                            isCargando = false
                        )
                    }
                }
            }
            catch (e: Exception){
                _estado.update { estadoActual ->
                    estadoActual.copy(
                        lista = null,
                        msgError = "Se produjo un error: ${e.message}",
                        isCargando = false
                    )
                }
            }
        }
    }
}