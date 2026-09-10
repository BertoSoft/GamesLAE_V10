package com.example.gameslae.core.model

import com.google.gson.annotations.SerializedName

data class DatosDto(
    val nombreSorteo: String,
    val fecha: String,
    val diaSemana: String,
    val estado: String,
    val combinacion: List<Int>,
    val complementario: Int?,
    val reintegro: Int?,
    val estrellas: List<Int>?,
    val bote: String
)

data class ContenedorDto(
    val exito: Boolean,
    val timestamp: String,
    val listaSorteos: List<DatosDto>
)

data class InicioDto(
    @SerializedName("success") val todoOk: Boolean,
    @SerializedName("data") val data: DataDto,
    @SerializedName("timestamp") val timeStamp: String
)

data class DataDto(
    @SerializedName("results") val resultados: Map<String, ResultadosDto>
)

data class ResultadosDto(
    @SerializedName("game") val nombre: NombreDto,
    @SerializedName("drawDate") val fecha: String,
    @SerializedName("dayOfWeek") val diaSemana: String,
    @SerializedName("status") val escrutinio: String,
    @SerializedName("combination") val numeros: List<Int>,
    @SerializedName("resultData") val resulData: SuplementosDto,
    @SerializedName("jackpotFormatted") val bote: String
)

data class NombreDto(
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val nombre: String
)

data class SuplementosDto(
    @SerializedName("complementario") val complementario: Int?,
    @SerializedName("reintegro") val reintegro: Int?,
    @SerializedName("estrellas") val estrellas: List<Int>?
)
