package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.data.remote.models.CharacterList
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersApi {

    @GET("character/")
    suspend fun getCharacterList(): CharacterList

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): Character
}