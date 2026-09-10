package com.example.gameslae.core.datasource

import com.example.gameslae.core.di.IoDispatcher
import com.example.gameslae.core.model.DatosRss
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource@Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher // 🌟 Usamos el dispatcher inyectado por Hilt
) {

    // Función que ejecutará el Repositorio para obtener los datos sucios
    suspend fun fetchLoteriaRssBruto(): String {

        // 🔄 Forzamos que la petición de internet se ejecute en el hilo de red (IO), no en la UI
        return withContext(ioDispatcher) {
            try {
                // 🌟 Llamada directa sin duplicar la URL base
                val respuesta = apiService.getResultadosRss()


                // Si el servidor responde bien (Código 200 OK) y trae datos, los devolvemos
                if (respuesta.isSuccessful && respuesta.body() != null) {
                    respuesta.body()!!.string()
                } else {




                    val codigoError = respuesta.code()
                    val mensajeError = respuesta.errorBody()?.string() ?: "Sin mensaje"




                    "" // Si falla el servidor, devolvemos una lista vacía de seguridad
                }
            } catch (e: Exception) {
                // Si el usuario no tiene internet o falla la conexión, capturamos el error
                ""
            }
        }
    }

}