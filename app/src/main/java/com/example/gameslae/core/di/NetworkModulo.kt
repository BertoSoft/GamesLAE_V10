package com.example.gameslae.core.di


import com.example.gameslae.core.datasource.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModulo {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            // Ponemos la URL base oficial de Loterías del Estado
            .baseUrl("https://www.loteriasyapuestas.es/")
            // Añadimos el conversor de texto/XML que añadimos a Gradle
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        // Hilt usa la instancia de Retrofit de arriba para fabricar tu interfaz
        return retrofit.create(ApiService::class.java)
    }
}