package com.example.gameslae.core.datasource

import com.example.gameslae.core.model.DatosRss
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Url


interface ApiService {

    // 🌟 Endpoint oficial de Loterías API para los últimos resultados de la Primitiva
    @GET("results/primitiva/latest")
    suspend fun getResultadosRss(): Response<ResponseBody>
}