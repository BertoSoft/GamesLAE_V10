package com.example.gameslae.core.mapper

import com.example.gameslae.core.model.DatosDto
import com.example.gameslae.modulos.home.domain.model.DatosHome
import com.example.gameslae.modulos.home.domain.model.TipoSorteo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun datosJsonToContenedorDto(jsonMap: Map<*, *>): List<DatosDto>? {
    val success = jsonMap["success"] as? Boolean ?: false
    val timeStamp = jsonMap["timestamp"] as? String ?: ""
    val data = jsonMap["data"] as? Map<*, *>

    val listaDto = data?.entries?.map { entradas ->
        val claveSorteo = entradas.key.toString()
        val datosSorteos = entradas.value as? Map<*, *>

        val game = datosSorteos?.get("game") as? Map<*, *>
        val resultData = datosSorteos?.get("resultData") as? Map<*, *>
        val filaCombinacion = datosSorteos?.get("combination") as? List<*>
        val filaEstrellas = resultData?.get("estrellas") as? List<*>

        val nombreSorteo = game?.get("name").toString()
        val fecha = datosSorteos?.get("drawDate").toString()
        val diaSemana = datosSorteos?.get("dayOfWeek").toString()
        val estado = datosSorteos?.get("status").toString()
        val combinacion = filaCombinacion?.mapNotNull { (it as? Number)?.toInt() } ?: emptyList()
        val complementario = (resultData?.get("complementario") as? Number)?.toInt()
        val reintegro = (resultData?.get("reintegro") as? Number)?.toInt()
        val estrellas = filaEstrellas?.mapNotNull { (it as? Number)?.toInt() }
        val bote = datosSorteos?.get("jackpotFormatted").toString()

        DatosDto(
            nombreSorteo = nombreSorteo,
            fecha = fecha,
            diaSemana = diaSemana,
            estado = estado,
            combinacion = combinacion,
            complementario = complementario,
            reintegro = reintegro,
            estrellas = estrellas,
            bote = bote
        )
    }
     return listaDto
}

fun DatosDto.toDomain(): DatosHome{

    val tipoSorteo = when (this.nombreSorteo.lowercase()) {
        "la primitiva", "primitiva" -> TipoSorteo.Primitiva
        "bonoloto" -> TipoSorteo.Bonoloto
        "euromillones" -> TipoSorteo.Euromillones
        else -> null
    }

    // 🌟 REPARADO: Parseo de fecha seguro usando la librería nativa para evitar crasheos por substring
    val fecha = try {
        LocalDate.parse(this.fecha, DateTimeFormatter.ISO_LOCAL_DATE)
    } catch (e: Exception) {
        LocalDate.of(1900, 1, 1) // Fecha por defecto si el texto viene corrupto
    }


    return DatosHome(
        tipoSorteo = tipoSorteo,
        numeroSorteo = null,
        fecha = fecha,
        numeros = this.combinacion,
        complementario = this.complementario,
        reintegro = this.reintegro,
        estrellas = this.estrellas
    )
}