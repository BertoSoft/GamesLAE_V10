package com.example.gameslae.core.datasource
import com.example.gameslae.core.model.RespuestaLoteriasApi
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    // 🌟 Endpoint oficial de Loterías API para los últimos resultados de la Primitiva
    @GET("results/latest")
    suspend fun getResultadosJson(): Response<RespuestaLoteriasApi>
}