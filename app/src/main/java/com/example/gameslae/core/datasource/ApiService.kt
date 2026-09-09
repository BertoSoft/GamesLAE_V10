package com.example.gameslae.core.datasource

import com.example.gameslae.core.model.DatosRss
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    // Le indicamos la ruta del RSS de loterías (ejemplo ficticio de ruta)
    @GET("es/la-primitiva/resultados/.formatoRSS")
    suspend fun getResultadosRss(): Response<String>
}