package com.example.gameslae.modulos.home.domain.model

import java.time.LocalDate

data class DatosHome(
    val tipoSorteo: TipoSorteo,
    val numeroSorteo: Int,
    val fecha: LocalDate,
    val numeros: List<Int>,
    val complementario: Int?,
    val reintegro: Int?,
    val estrellas: List<Int>?
)

enum class TipoSorteo{
    Primitiva,
    Bonoloto,
    Euromillones
}
