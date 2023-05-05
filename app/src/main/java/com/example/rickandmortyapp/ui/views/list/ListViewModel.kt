package com.example.rickandmortyapp.ui.views.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.repositories.models.CharacterItem
import com.example.rickandmortyapp.repositories.remote.CharacterRepository
import com.example.rickandmortyapp.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    var characterList = mutableStateOf<List<CharacterItem>>(listOf())
    var isLoading = mutableStateOf(false)
    var loadError = mutableStateOf("")

    init {
        loadCharacters()
    }

    private fun loadCharacters() {

        viewModelScope.launch {
            isLoading.value = true

            when(val result = repository.getAllCharacters()){
                is Resource.Success -> {
                    val charactersItems = result.data?.results?.map { character ->
                         CharacterItem(
                            id = character.id,
                            name = character.name,
                            url = character.url,
                            image = character.image
                        )
                    } ?: listOf()

                    loadError.value = ""
                    characterList.value = charactersItems
                }
                is Resource.Error -> {
                    loadError.value = result.message ?: "Unknown error"
                }
                is Resource.Loading -> Unit
            }
            isLoading.value = false
        }
    }
}