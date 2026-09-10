package com.example.gameslae.core.datasource

import com.example.gameslae.core.di.IoDispatcher
import com.example.gameslae.core.model.DataDto
import com.example.gameslae.core.model.DatosDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource@Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher // 🌟 Usamos el dispatcher inyectado por Hilt
) {

    // Función que ejecutará el Repositorio para obtener los datos sucios
    suspend fun getDatosUltimosSorteosDto(): String {

        // 🔄 Forzamos que la petición de internet se ejecute en el hilo de red (IO), no en la UI
        return withContext(ioDispatcher) {
            try {
                val respuesta = apiService.getResultadosRss()
                if (respuesta.isSuccessful && respuesta.body() != null) {
                    respuesta.body()!!.string()
                } else {
                    ""// Si falla el servidor, devolvemos una lista vacía de seguridad
                }
            } catch (e: Exception) {
                // Si el usuario no tiene internet o falla la conexión, capturamos el error
                ""
            }
        }
    }

}