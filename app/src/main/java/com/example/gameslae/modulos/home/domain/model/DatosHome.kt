package com.example.gameslae.modulos.home.domain.model

import java.time.LocalDate

data class DatosHome(
    val tipoSorteo: TipoSorteo? = null,
    val numeroSorteo: Int? = null,
    val fecha: LocalDate? = null,
    val numeros: List<Int>? = null
)

enum class TipoSorteo{
    Primitiva,
    Bonoloto,
    Euromillones
}
