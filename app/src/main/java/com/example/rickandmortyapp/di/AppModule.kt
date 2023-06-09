package com.example.rickandmortyapp.di

import android.content.Context
import coil.request.ImageRequest
import com.example.rickandmortyapp.data.remote.CharactersApi
import com.example.rickandmortyapp.repositories.remote.CharacterRepository
import com.example.rickandmortyapp.repositories.remote.CharacterRepositoryImpl
import com.example.rickandmortyapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCharacterApi(): CharactersApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CharactersApi::class.java)
    }


    @Singleton
    @Provides
    fun provideRepository(
        api: CharactersApi
    ): CharacterRepository = CharacterRepositoryImpl(api)
}