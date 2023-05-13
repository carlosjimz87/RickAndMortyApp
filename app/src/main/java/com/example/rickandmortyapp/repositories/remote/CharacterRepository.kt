package com.example.rickandmortyapp.repositories.remote

import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.data.remote.models.CharacterList
import com.example.rickandmortyapp.repositories.models.CharacterDetails
import com.example.rickandmortyapp.utils.Resource

interface CharacterRepository {
    suspend fun getAllCharacters(): Resource<CharacterList>
    suspend fun getCharacter(id: String): Resource<CharacterDetails>
}