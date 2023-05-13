package com.example.rickandmortyapp.ui.views.details

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.repositories.models.CharacterDetails
import com.example.rickandmortyapp.repositories.remote.CharacterRepository
import com.example.rickandmortyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    suspend fun getCharacterDetails(id: String): Resource<CharacterDetails> {
        return repository.getCharacter(id)
    }
}