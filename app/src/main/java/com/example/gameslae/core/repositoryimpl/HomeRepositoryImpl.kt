package com.example.gameslae.core.repositoryimpl

import com.example.gameslae.core.datasource.RemoteDataSource
import com.example.gameslae.modulos.home.domain.model.DatosHome
import com.example.gameslae.modulos.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl@Inject constructor(
    private val remoteDataSource: RemoteDataSource
): HomeRepository {

    override suspend fun getDatos(): String {
        return remoteDataSource.fetchLoteriaRssBruto()
    }
}