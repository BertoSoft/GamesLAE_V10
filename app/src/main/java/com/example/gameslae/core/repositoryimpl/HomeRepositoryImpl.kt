package com.example.gameslae.core.repositoryimpl

import com.example.gameslae.core.datasource.RemoteDataSource
import com.example.gameslae.core.mapper.datosJsonToContenedorDto
import com.example.gameslae.core.mapper.toDomain
import com.example.gameslae.modulos.home.domain.model.DatosHome
import com.example.gameslae.modulos.home.domain.repository.HomeRepository
import com.google.gson.Gson
import javax.inject.Inject

class HomeRepositoryImpl@Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val gson: Gson
): HomeRepository {

    override suspend fun getDatosUltimosSorteos(): List<DatosHome> {
        val datosJsonString = remoteDataSource.getDatosUltimosSorteosDto()
        if(datosJsonString.isBlank()) return emptyList()

        return try {
            val jSonMap = gson.fromJson(datosJsonString, Map::class.java)
            if(jSonMap != null){
                val listaDatosDto = datosJsonToContenedorDto(jSonMap)
                listaDatosDto!!.map { entradas ->
                    entradas.toDomain()
                }
            }
            else{
                emptyList()
            }
        }
        catch (e: Exception){
            emptyList<DatosHome>()
        }
    }
}