package com.example.gameslae.core.model

import com.google.gson.annotations.SerializedName


/**
 * 1. Objeto raíz del JSON. Captura el { "success": true, ... }
 */
data class RespuestaLoteriasApi(
    @SerializedName("success") val esExitoso: Boolean,
    @SerializedName("data") val data: ContenedorLoteriasDto?
)

/**
 * 2. Mapea el objeto interno de "data".
 * En lugar de escribir una variable fija por cada juego, usamos un Map dinámico.
 * Clave (String): El nombre técnico ("bonoloto", "primitiva", etc.)
 * Valor (DetalleSorteoDto): El objeto con el resultado completo del juego.
 */
class ContenedorLoteriasDto : HashMap<String, DetalleSorteoDto>()

/**
 * 3. Mapea la información detallada de cada sorteo individual
 */
data class DetalleSorteoDto(
    @SerializedName("id") val id: String?,
    @SerializedName("drawId") val drawId: String?,
    @SerializedName("drawDate") val fechaSorteo: String?,
    @SerializedName("dayOfWeek") val diaSemana: String?,
    @SerializedName("year") val anio: Int?,
    @SerializedName("status") val estado: String?,
    @SerializedName("jackpotFormatted") val boteFormateado: String?,
    @SerializedName("combination") val combinacion: List<Int>?,
    @SerializedName("game") val juego: JuegoInfoDto?,
    @SerializedName("prizes") val premios: List<PremioDto>?,
    @SerializedName("resultData") val resuldata: ResultDataFlexible?,
)

/**
 * 4. Mapea el nombre legible del juego
 */
data class JuegoInfoDto(
    @SerializedName("slug") val codigo: String?,
    @SerializedName("name") val nombre: String?
)

/**
 * 5. Mapea el desglose de acertantes y premios en euros
 */
data class PremioDto(
    @SerializedName("category") val categoria: Int?,
    @SerializedName("categoryName") val nombreCategoria: String?,
    @SerializedName("winners") val acertantes: Int?,
    @SerializedName("formattedPrize") val premioFormateado: String?,
)

    /**
     * * Mapeamos el campo de las estrellas y el complementario y reintegro
     */
    data class ResultDataFlexible(
        @SerializedName("complementario") val complementario: Int?,
        @SerializedName("reintegro") val reintegro: Int?,
        @SerializedName("estrellas") val estrellas: List<Int>?
    )
