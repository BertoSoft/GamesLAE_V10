package com.example.gameslae.modulos.home.domain.repository

import com.example.gameslae.modulos.home.domain.model.DatosHome

interface HomeRepository {
    suspend fun getDatos(): List<DatosHome>
}