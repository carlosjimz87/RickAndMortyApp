package com.example.rickandmortyapp.repositories.remote

import com.example.rickandmortyapp.data.remote.CharactersApi
import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.data.remote.models.CharacterList
import com.example.rickandmortyapp.repositories.models.CharacterDetails
import com.example.rickandmortyapp.utils.Resource
import com.example.rickandmortyapp.utils.toCharacterDetails
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val charactersApi: CharactersApi
) : CharacterRepository {

    override suspend fun getAllCharacters(): Resource<CharacterList> {
        val characters = try {
            charactersApi.getCharacterList()
        } catch (e: Exception) {
            return Resource.Error("An unknown error [$e]")
        }
        return Resource.Success(characters)
    }

    override suspend fun getCharacter(id: String): Resource<CharacterDetails> {
        val character = try {
            charactersApi.getCharacter(id)
        } catch (e: Exception) {
            return Resource.Error("An unknown error [$e]")
        }
        return Resource.Success(character.toCharacterDetails())
    }
}