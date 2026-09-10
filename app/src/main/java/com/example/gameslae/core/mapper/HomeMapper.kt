package com.example.gameslae.core.mapper

import android.content.Context
import com.example.gameslae.core.model.ContenedorDto
import com.example.gameslae.core.model.DataDto
import com.example.gameslae.core.model.DatosDto
import com.example.gameslae.core.model.InicioDto
import com.example.gameslae.core.model.ResultadosDto


/**
 * Convierte la respuesta raíz de la API (InicioDto) en el contenedor
 * de dominio (ContenedorDto) con la lista plana de sorteos.
 */

fun InicioDto.toDomain(): ContenedorDto{
    return ContenedorDto(
        exito = this.todoOk,
        timestamp = this.timeStamp,
        listaSorteos = this.data.resultados.map { (sorteo, datosDto) ->
            datosDto.toDomain()
        }
    )
}

/**
 * Convierte un sorteo individual del JSON (ResultadosDto) al modelo de negocio (DatosDto).
 * @param idJuego Es la clave del mapa (ej: "euromillones", "primitiva"). Puedes usarla
 * si necesitas mapear un ID único, aunque en DatosDto usamos directamente el nombre legible.
 */

fun ResultadosDto.toDomain(): DatosDto{
    return DatosDto(
        nombreSorteo = this.nombre.nombre,
        fecha = this.fecha,
        diaSemana = this.diaSemana,
        estado = this.escrutinio,
        combinacion = this.numeros,
        complementario = this.resulData.complementario,
        reintegro = this.resulData.reintegro,
        estrellas =  this.resulData.estrellas,
        bote = this.bote
    )
}