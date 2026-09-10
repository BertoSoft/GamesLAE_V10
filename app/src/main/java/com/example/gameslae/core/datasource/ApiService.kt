package com.example.gameslae.core.datasource

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // 🌟 Endpoint oficial de Loterías API para los últimos resultados de la Primitiva
    @GET("results/primitiva/latest")
    suspend fun getUltimosSorteosDto(): Response<ResponseBody>
}