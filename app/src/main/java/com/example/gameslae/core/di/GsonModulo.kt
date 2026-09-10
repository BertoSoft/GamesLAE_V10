package com.example.gameslae.core.di


import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
        // Aquí podrías añadir configuraciones extra en el futuro si lo necesitas,
        // por ejemplo: .setDateFormat("yyyy-MM-dd")
    }
}

