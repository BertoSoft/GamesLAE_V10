package com.example.gameslae.core.datasource

import com.example.gameslae.core.di.IoDispatcher
import com.example.gameslae.core.model.DetalleSorteoDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource@Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher // 🌟 Usamos el dispatcher inyectado por Hilt
) {

    // Esta función unifica de forma automática todos los juegos en una sola lista limpia
    suspend fun getDatosOnline(): List<DetalleSorteoDto> {
        return withContext(ioDispatcher) {
            try {
                val respuesta = apiService.getResultadosJson()

                if (respuesta.isSuccessful && respuesta.body() != null) {
                    val contenedor = respuesta.body()!!.data

                    // Extraemos los valores del mapa (bonoloto, primitiva...) y los pasamos a lista
                    contenedor?.values?.toList() ?: emptyList()
                } else {
                    emptyList()
                }
            } catch (e: Exception) {
                emptyList() // Si hay error de red, devolvemos una lista vacía segura
            }
        }
    }
}