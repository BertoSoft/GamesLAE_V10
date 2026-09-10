package com.example.gameslae.modulos.home.domain.usecase

import com.example.gameslae.modulos.home.domain.model.DatosHome
import com.example.gameslae.modulos.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase@Inject constructor(
    private val repository: HomeRepository
) {

    suspend fun getDatosUltimosSorteosUseCase(): List<DatosHome>{

        val xml = repository.getDatosUltimosSorteos()












        return emptyList<DatosHome>()
    }
}